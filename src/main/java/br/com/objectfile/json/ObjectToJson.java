package br.com.objectfile.json;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.GsonBuilder;

public class ObjectToJson {

	public ObjectToJson(Object createJson, String absolutePath) {
		String jsonInString = new GsonBuilder().setPrettyPrinting().create().toJson(createJson);
		FileWriter file;
		try {
			file = new FileWriter(absolutePath, false);
			file.write(jsonInString);
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
