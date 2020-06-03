package com.codenation.caesar_cipher;

import java.security.MessageDigest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.codenation.caesar_cipher.entity.CipherResponse;

public class Cryptography {

	private static final Logger LOGGER = LogManager.getLogger(Cryptography.class.getName());

	public static void decodeCaesar(CipherResponse cipher) {

		int nCasas = cipher.getNumeroCasas();
		char[] cifrado = cipher.getCifrado().toLowerCase().toCharArray();
		char[] output = new char[cifrado.length];

		LOGGER.info("Decoding cipher ...");

		for (int i = 0; i < cifrado.length; i++) {
			int ascCharacter = (int) cifrado[i];

			if (ascCharacter > 96 && ascCharacter < 123) {
				int novaPosicao = ascCharacter - nCasas;
				if (novaPosicao < 97) {
					output[i] = (char) (26 + novaPosicao);
				} else {
					output[i] = (char) novaPosicao;
				}

			} else {
				output[i] = cifrado[i];
			}
		}

		LOGGER.info("Decoded succesfully.");
		cipher.setDecifrado(new String(output));

	}

	public static void sha1Encrypt(CipherResponse cipher) {
		try {
			LOGGER.info("Starting SHA-1 encryption ...");
			MessageDigest algorithm = MessageDigest.getInstance("SHA-1");
			byte messageDigest[] = algorithm.digest(cipher.getDecifrado().getBytes("UTF-8"));

			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
				hexString.append(String.format("%02X", 0xFF & b));
			}
			String senhahex = hexString.toString();

			cipher.setResumoCriptografico(senhahex);
			LOGGER.info("SHA-1 encrypted succesfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
