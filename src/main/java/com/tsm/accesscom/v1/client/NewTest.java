package com.tsm.accesscom.v1.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.maxoptra.api.v1.client.TSMRestClient;

public class NewTest {
	public static void main(String[] args) throws IOException {
		
		String cookie = autheticateSchedule();
		
		TSMRestClient instance = TSMRestClient.getInstance();
		
		
		instance.autoSchedule(cookie);
	}

	public static String autheticateSchedule() throws IOException{
		String cookie="";
		URL url;
		HttpURLConnection connection = null;
		try {
			String urlParameters = "login=tsm.dispatcher&password=456RTYfgh&account=tsm&remember=false";
			// Create connection
			url = new URL("http://service.maxoptra.com/gt/gt-api/auth/login?");
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");

			connection.setRequestProperty("Content-Length",
					"" + Integer.toString(urlParameters.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");

			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);

			// Send request
			DataOutputStream wr = new DataOutputStream(
					connection.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			// Get Cookie
			List<String> cookies = connection.getHeaderFields().get(
					"Set-Cookie");
			for (String c : cookies) {
				System.out.print(c);
				cookie +=c; 
			}
			System.out.println();

			// Get Response
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			System.out.println(response.toString());

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("ERROR");
			;

		} finally {

			if (connection != null) {
				connection.disconnect();
			}
		}

		System.out.println("******************************************************************");
		System.out.println("Cookie : "+cookie);
		System.out.println("******************************************************************");
		
		return cookie;
	}
	
}
