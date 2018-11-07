/* Roman Sorin - 11.5.18
 * Provides getter and setter methods for the content of
 * the e-mail, including subject, recipient, and the
 * actual message.
 */

package main;

import java.util.Scanner;

public class MessageText {
	private static String content;
	private static String subject;
	private static String recipient;

	private static Scanner input = new Scanner(System.in);

	public static void setContent() {
		System.out.println("Enter message content: ");
		content = input.nextLine();
	}

	public static void setSubject() {
		System.out.println("Enter subject: ");
		subject = input.nextLine();
	}

	public static void setRecipient() {
		System.out.println("Send to: ");
		recipient = input.nextLine();
	}

	public static String getContent() {
		return content;
	}

	public static String getSubject() {
		return subject;
	}

	public static String getRecipient() {
		return recipient;
	}

}
