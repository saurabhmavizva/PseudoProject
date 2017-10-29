package com.avizva.utility;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PasswordUtility {

	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * This method is a utility method which generates a temporary password and
	 * returns it
	 * 
	 * @return String
	 */
	public static String generatePassword() {
		// Generates Random Passwords
		Random random = new Random();
		StringBuilder password = new StringBuilder();
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		for (int count = 0; count <= 8; count++) {
			int index = (int) (random.nextFloat() * SALTCHARS.length());
			password.append(SALTCHARS.charAt(index));
		}
		password.append("@Aa1"); // To bypass the validations
		return password.toString();
	}

	/**
	 * This method is used to encrypt the password into MD5
	 * 
	 * @param password
	 * @return String
	 */

	public static String encryptPassword(String password) {

		if (password == null) {
			return null;
		}
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(password.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);
			// Now we need to zero pad it if you actually want the full 32
			// chars.
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("Error Occured Could not Encrypt Password");
			return null;
		}

	}

}
