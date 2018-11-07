/* Roman Sorin - 11.5.18
 * Runs the email display application
 */

package main;

public class EmailDisplayRunner {

	public static void main(String[] args) {
		Credentials.setUsername();
		Credentials.setPassword();

		MailReceiver.check(Credentials.getUsername(), Credentials.getPassword());
		MailSender.sendMessage(Credentials.getUsername(), MessageText.getSubject(), MessageText.getContent(),
				MessageText.getRecipient());
	}

}
