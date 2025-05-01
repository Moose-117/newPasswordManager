package com.mycompany.passwordmanager;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException, URISyntaxException {

		Scanner scanner = new Scanner(System.in);
		String choice;
		String passwordFound = null;
		do {
			System.out.println("premi 1 per leggere servizio, 2 per aggiungere");
			choice = scanner.nextLine();
			switch (choice) {

			case "1":
				System.out.println("sono in leggi servizio");
				try {
					System.out.println("inserisci servizio da cercare");
					String searchedSubscription = scanner.nextLine();
					passwordFound = ManageSubscriptions.readSubscription(searchedSubscription);
					System.out.println("password recuperata: " + passwordFound);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "2":
				try {
					String serviceRead = scanner.nextLine();
					String passwordRead = scanner.nextLine();
					ManageSubscriptions.addSubscription(serviceRead, passwordRead);
					System.out.println("sono in aggiungi servizio");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "3":
				try {
					String phone = "393270904320";
					String apikey = "1276104";

					String query = String.format("phone=%s&text=%s&apikey=%s",
							URLEncoder.encode(phone, StandardCharsets.UTF_8),
							URLEncoder.encode(passwordFound, StandardCharsets.UTF_8),
							URLEncoder.encode(apikey, StandardCharsets.UTF_8));

					URL url = new URI("https://api.callmebot.com/whatsapp.php?" + query).toURL();
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					con.setRequestMethod("GET");

					int responseCode = con.getResponseCode();
					System.out.println("response code = " + responseCode);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:

			}
		} while (!choice.equals("exit"));
		scanner.close();
	}
}