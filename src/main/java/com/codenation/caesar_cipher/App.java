package com.codenation.caesar_cipher;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.codenation.caesar_cipher.entity.CipherResponse;
import com.codenation.caesar_cipher.http.HttpConnection;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
	
	private static final Logger LOGGER = LogManager.getLogger(App.class.getName());
	
	public static void main(String[] args) {
		
		LOGGER.info("Connecting to codenation API Caesar cipher generator ...");
		StringBuffer content = HttpConnection.doGetRequest("https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=" + System.getenv("token"));
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			
			CipherResponse cipher = mapper.readValue(content.toString(), CipherResponse.class);
			mapper.writeValue(new File("target/answer.json"), cipher);
			
			Cryptography.decodeCaesar(cipher);
			System.out.println(cipher.getDecifrado());
			// criptografar em SHA1 no resumo_criptografico
			// fazer post request no endpoint https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=90aa5fb5d523cfe4951c077fc59395028008cc40
			// a API espera um arquivo sendo enviado como multipart/form-data, como se fosse enviado por um formulário HTML, 
			// com um campo do tipo file com o nome answer. Considere isso ao enviar o arquivo.
//			System.out.println(cipher.getResumoCriptografico());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
}