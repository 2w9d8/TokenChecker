package dev.sanhak.tokenchecker.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileObject {

	private File dataFile;

	public FileObject(String dataFileName) {
		this.dataFile = new File(System.getProperty("user.dir"), dataFileName);
		this.dataFile.getParentFile().mkdirs();
		if (!dataFile.exists()) {
			try {
				dataFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void write(String string) {
		if (this.dataFile.exists() && this.dataFile != null) {
			try (FileWriter fileWriter = new FileWriter(dataFile, true)) {
				fileWriter.append(string).append(System.lineSeparator());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void save() {
		try {
			FileWriter fileWriter = new FileWriter(dataFile, true);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}