package com.mycompany.passwordmanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class ManageSubscriptions {

	public static void addSubscription(final String stringa) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("nuovofile.txt");
		writer.println(stringa);
		writer.println("The second line");
		writer.close();
	}

	public static String readSubscription(final String searchedSubscription) throws FileNotFoundException {
		
		String nameAndPassRow = null;
		String subscriptionName = null;
		String password = null;
		try {
			File myObj = new File("nuovofile.txt");
			Scanner myReader = new Scanner(myObj);
			do {
				nameAndPassRow = myReader.nextLine();
				subscriptionName = nameAndPassRow.split(" ")[0];
				password = nameAndPassRow.split(" ")[1];
				System.out.println("subscription name" + subscriptionName);
				System.out.println("password" + password);
			} while((myReader.hasNextLine() && !subscriptionName.equals(searchedSubscription)));
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return password;
	}
}
