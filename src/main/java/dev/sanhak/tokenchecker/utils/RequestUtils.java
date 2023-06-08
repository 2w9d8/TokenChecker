package dev.sanhak.tokenchecker.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RequestUtils {

	public static void doRequest(String token, FileObject verifiedFile) {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url("https://discord.com/api/v9/users/@me")
				.header("Authorization", token).build();
		try {
			Response response = client.newCall(request).execute();
			if (response.isSuccessful()) {
				System.out.println("[!] " + token + " working ..!");
				verifiedFile.write(token);
			} else {
				System.out.println("[!] " + token + " not working ..!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
