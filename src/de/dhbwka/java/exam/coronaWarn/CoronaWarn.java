package de.dhbwka.java.exam.coronaWarn;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class CoronaWarn {

	/**
	 * Application entry point for CoronaWarn
	 *
	 * @param args command line arguments, not used here
	 */

	public static void main(String[] args) {
		try {
			// Only necessary on MacOS to prevent color issues with standard look and feel.
			// Redundant on other operation systems - they use this look and feel by default.
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		}
		catch ( final Exception e ) {
		}

		JPhone phone1 = new JPhone("0123-4567", "Markus");
		JPhone phone2 = new JPhone("9876-5432", "Angela");
		JPhone phone3 = new JPhone("4711-0815", "Olaf");

		CoronaWarnTerm client1 = new CoronaWarnTerm(phone1);
		CoronaWarnTerm client2 = new CoronaWarnTerm(phone2);
		CoronaWarnTerm client3 = new CoronaWarnTerm(phone3);

		CoronaWarnAPI.registerClients(client1,client2,client3);
	}

	/**
	 * Clear token store for phone
	 *
	 * @param phone phone to clear store for
	 */
	public static void clearTokenStore(JPhone phone) {

		Path storage = Paths.get("src/de/dhbwka/java/exam/CoronaWarn/" + phone.getId() + "-tokens.txt");

		try (BufferedWriter bw = Files.newBufferedWriter(storage, StandardCharsets.UTF_8)) {
			bw.write("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Clear token store");
	}

	/**
	 * Load tokens for phone
	 *
	 * @param phone phone to load tokens for
	 *
	 * @return loaded tokens
	 */
	public static List<Token> loadTokens(JPhone phone){
		List<Token> tokens = new LinkedList<>();

		Path storage = Paths.get("src/de/dhbwka/java/exam/CoronaWarn/" + phone.getId() + "-tokens.txt");
		
		try {
			if(Files.exists(storage)){
				tokens = Files.readAllLines(storage).stream().map(line -> parseToken(line)).toList();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tokens;
	}

	/**
	 * Save token for provided phone
	 *
	 * @param phone phone to save token for
	 * @param token token to save
	 */
	public static void saveToken(JPhone phone, Token token) {

		String line = token.getValue() + ";" + token.getDate().getTime() + "\n";
		
		Path storage = Paths.get("src/de/dhbwka/java/exam/CoronaWarn/" + phone.getId() + "-tokens.txt");

		try {
			if(!Files.exists(storage)){
				Files.createFile(storage);
			}
			Files.writeString(storage, line, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Failed to save Token!");
		}
	}

	/**
	 * Parse a token line
	 *
	 * @param line token line to parse
	 *
	 * @return parsed token instance
	 */
	private static Token parseToken(String line) {
		String[] parts = line.split("[;]");
		if (parts.length == 2 ) {
			try {
				return new Token(parts[0], new Date(Long.parseLong(parts[1])));
			} catch (Exception e) {
				System.err.println("Error parsing token line: " + line);
				e.printStackTrace();
			}
		}
		return null;
	}
}
