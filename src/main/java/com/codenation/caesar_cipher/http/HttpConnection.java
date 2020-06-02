package com.codenation.caesar_cipher.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
	
	public static void doPostRequest() {
		// TODO
	}
}
