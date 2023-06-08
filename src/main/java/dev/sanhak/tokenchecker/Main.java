package dev.sanhak.tokenchecker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dev.sanhak.tokenchecker.utils.FileObject;
import dev.sanhak.tokenchecker.utils.RequestUtils;

public class Main {

	private static FileObject file;

	public static void main(String[] args) throws Exception {
		file = new FileObject("verified.txt");
		List<String> tokens = new ArrayList<>();
		System.out.println("[!] Loading tokens ...!");
		try (BufferedReader reader = new BufferedReader(
				new FileReader(new File(System.getProperty("user.dir"), "tokens.txt")))) {
			String line;
			while ((line = reader.readLine()) != null) {
				tokens.add(line);
			}
		} catch (IOException e) {
			if (e instanceof FileNotFoundException) {
				System.err.println("[!] tokens.txt not found , please create one and drop tokens into it !");
			} else {
				e.printStackTrace();
			}
		}

		Thread.sleep(new File(System.getProperty("user.dir"), "tokens.txt").length() / 1024);
		System.out.println("[!] loaded " + tokens.size() + " token !");
		System.out.println("[!] Starting ...\n");
		if (!tokens.isEmpty()) {
			for (String token : tokens) {
				RequestUtils.doRequest(token, getFile());
			}
		} else {
			System.err.println("[!] The tokens.txt cannot be empty !");
		}
	}

	public static FileObject getFile() {
		if (file == null) {
			file = new FileObject("verified.txt");
		}
		return file;
	}

}
