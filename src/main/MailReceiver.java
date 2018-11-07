/* Roman Sorin - 11.5.18
 * Fetches emails from inbox of account
 * Currently only CHECKS (i.e. no content is displayed or expanded)
 */

package main;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class MailReceiver {
	public static void check(String username, String password) {
		try {
			// Create a new properties object, set protocol to Google's 'imaps'
			Properties props = new Properties();
			props.setProperty("mail.store.protococl", "imaps");

			props.put("mail.imap.host", "imap.gmail.com");
			props.put("mail.imap.port", "993");
			props.put("mail.imap.starttls.enable", "true");

			// Create an email session from properties.
			// Use getInstance over getDefaultInstance to prevent overlap of
			// instances
			Session emailSession = Session.getInstance(props);

			Store store = emailSession.getStore("imaps");

			// Establish connection between session and store
			store.connect("imap.gmail.com", Credentials.getUsername(), Credentials.getPassword());

			// Create folder from established connection
			// Folder is set to content within inbox
			Folder emailFolder = store.getFolder("[Gmail]/All Mail");
			emailFolder.open(Folder.READ_ONLY);

			// Create array of messages found in folder
			Message[] messages = emailFolder.getMessages();
			System.out.println("messages.length---" + messages.length);

			// Limit the numbr of displayed messages to 25
			int numOfMessages = 25;

			// Start at end of array and print emails in reverse order:
			// Basically, emails will be displayed from newest to oldest (top to
			// bottom)
			for (int i = messages.length - 1; i >= messages.length - numOfMessages; i--) {
				Message message = messages[i];
				System.out.println("---------------------------------");
				System.out.println("Email Number " + (i - 1));
				System.out.println("Subject: " + message.getSubject());
				System.out.println("From: " + message.getFrom()[0]);
			}
			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
