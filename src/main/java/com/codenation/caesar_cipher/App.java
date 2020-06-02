package com.codenation.caesar_cipher;

import java.io.File;
import java.io.IOException;

import com.codenation.caesar_cipher.entity.Cipher;
import com.codenation.caesar_cipher.http.HttpConnection;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
	public static void main(String[] args) {
		StringBuffer content = HttpConnection.doGetRequest("https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=90aa5fb5d523cfe4951c077fc59395028008cc40");
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			
			Cipher cipher = mapper.readValue(content.toString(), Cipher.class);
			mapper.writeValue(new File("target/answer.json"), cipher);
			
			// TODO pegar o numero de casa
			// implementar o código para decodificar baseado no numero de casa
			// escrever novo json com a resposta no campo decifrado
			// criptografar em SHA1 no resumo_criptografico
			// fazer post request no endpoint https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=90aa5fb5d523cfe4951c077fc59395028008cc40
			// a API espera um arquivo sendo enviado como multipart/form-data, como se fosse enviado por um formulário HTML, 
			// com um campo do tipo file com o nome answer. Considere isso ao enviar o arquivo.
			System.out.println(cipher.getResumoCriptografico());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
}