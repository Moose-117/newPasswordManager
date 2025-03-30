package com.mycompany.passwordmanager;

import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException {

		Scanner scanner = new Scanner(System.in);
		String choice;
		do {
			System.out.println("premi 1 per leggere servizio, 2 per aggiungere");
			choice = scanner.nextLine();
			switch (choice) {

			case "1":
				System.out.println("sono in leggi servizio");
				try {
					String searchedSubscription = "subscriptionName2";
					ManageSubscriptions.readSubscription(searchedSubscription);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "2":
				try {
					ManageSubscriptions.addSubscription("stringa");
					System.out.println("sono in aggiungi servizio");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:

			}
		} while (!choice.equals("exit"));
	}
}
