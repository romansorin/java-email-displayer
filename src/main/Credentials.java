/* Roman Sorin - 11.5.18
 * Methods to get and set required credentials for 
 * establishing a connection to email.
 */

package main;

import java.util.Scanner;

public class Credentials {
	private static String mail;
	private static String password;

	private static Scanner input = new Scanner(System.in);

	public static String getUsername() {
		return mail;
	}

	public static String getPassword() {
		return password;
	}

	public static void setUsername() {
		System.out.println("Enter username: ");
		mail = input.nextLine();
	}

	public static void setPassword() {
		System.out.println("Enter password: ");
		password = input.nextLine();
	}
}
