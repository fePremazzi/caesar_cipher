package com.codenation.caesar_cipher.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

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
			URL url = new URL(url_cn);
			
			//https://gist.github.com/mcxiaoke/8929954
			//https://www.programming-books.io/essential/android/upload-post-file-using-httpurlconnection-4b647c18f1ab42679a23212cbdb7047d
			//https://www.baeldung.com/httpurlconnection-post

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");

			con.setRequestProperty("Content-Type", "multipart/form-data; boundary=\"boundary\"");
			con.setRequestProperty("Content-Disposition","form-data; name=\"file\"; filename=\"answer.json\"");
			
			con.setDoOutput(true);			
						
			try(OutputStream os = con.getOutputStream()){
				byte[] input = json.getBytes(StandardCharsets.UTF_8);
				os.write(input);			
			}

			int code = con.getResponseCode();
			System.out.println(code);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
