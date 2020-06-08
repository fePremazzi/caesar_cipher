package com.codenation.caesar_cipher.http;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

public class HttpConnection {

	// Basic method for a Get httpRequest
	public static StringBuffer doGetRequest(String url) {
		StringBuffer content = null;
		try {
			URL url2 = new URL(url);
			HttpURLConnection con = (HttpURLConnection) url2.openConnection();
			con.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();

		} catch (Exception e) {
			return content.append(e.getMessage());
		}
		return content;
	}

	public static void doPostRequest(String url_cn, String json) {
		try {
			
			Unirest.setTimeouts(0, 0);
			HttpResponse<String> response = Unirest.post(url_cn)
			  .field("answer", new File("target/answer.json"))
			  .asString();
			
			System.out.println("Status: " + response.getStatus());
			System.out.println("Content: " + response.getBody());
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
