package main;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
	private static String domainString = "@gmail.com";

	public static void sendMessage(String sender, String subject, String content, String recipient) {
		/*
		 * Create new properties object and establishes instance/session with
		 * SMTP server
		 */
		Properties props = new Properties();

		props.put("mail.smtp.host", "smtp.gmail.com"); /* G-Mail domain */
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		Session emailSession = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Credentials.getUsername(), Credentials.getPassword());
			}
		});

		/* Prompts user for subject, content, and recipient */
		MessageText.setSubject();
		MessageText.setContent();
		MessageText.setRecipient();

		/*
		 * In case the user provides an email without @gmail.com, this if block
		 * will append the domain
		 */
		if (Credentials.getUsername().contains(domainString)) {
			int ampersatOccurence = Credentials.getUsername().indexOf('@');
			sender = Credentials.getUsername().substring(0, ampersatOccurence);
		} else {
			sender = Credentials.getUsername() + domainString;
		}

		/* Sends the actual message */
		try {
			Message msg = new MimeMessage(emailSession);
			msg.setFrom(new InternetAddress(sender));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(MessageText.getRecipient()));
			msg.setSubject(MessageText.getSubject());
			msg.setText(MessageText.getContent());
			Transport trans = emailSession.getTransport("smtp");
			Transport.send(msg);
			System.out.println("Your message has been sent!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
