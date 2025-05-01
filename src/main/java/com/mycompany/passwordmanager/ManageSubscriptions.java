package com.mycompany.passwordmanager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class ManageSubscriptions {

	public static void addSubscription(final String serviceRead, final String passwordRead) throws IOException {

		File file = new File("./nuovofile.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fileWriter = new FileWriter(file, true);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		PrintWriter printWriter = new PrintWriter(bufferedWriter);

		printWriter.println(serviceRead + " " + passwordRead);
		printWriter.close();
	}

	public static String readSubscription(final String searchedSubscription) throws FileNotFoundException {

		String nameAndPassRow = null;
		String subscriptionName = null;
		String password = null;
		String passwordRecuperata = null;
		boolean trovato = false;

		try {
			File myObj = new File("nuovofile.txt");
			Scanner myReader = new Scanner(myObj);
			do {
				nameAndPassRow = myReader.nextLine();
				subscriptionName = nameAndPassRow.split(" ")[0];
				password = nameAndPassRow.split(" ")[1];
				trovato = subscriptionName.equals(searchedSubscription);
				passwordRecuperata = trovato ? password : null;

			} while ((myReader.hasNextLine() && !trovato));
			myReader.close();
			return passwordRecuperata;
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return password;
	}
}
