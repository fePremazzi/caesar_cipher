package com.codenation.caesar_cipher;

import java.util.ArrayList;

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
				}else {
					output[i] = (char) novaPosicao;
				}
				
			} else {
				output[i] = cifrado[i];
			}
		}
		LOGGER.info("Decoded succesfully.");
		cipher.setDecifrado(new String(output));

	}
}
