package com.dbiz.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class JsonReader {

	private ObjectMapper objectMapper;
	File jsonFile;
	Map<String, Object> body;



	public JsonReader() {
		objectMapper = new ObjectMapper();
	}

	public Map<String, Object> jsonData(String jsonFileName) {
		try {
				body = objectMapper.readValue(new File("C:/dbizrepo/dbiz.aiAutomation/data/API_Data/" + jsonFileName), Map.class);
				if (body == null) {
					throw new RuntimeException("NO DATA FOUND in JSON file '" + jsonFileName + "'");
				}
			
		}

		catch (FileNotFoundException e) {
			throw new RuntimeException("JSON file not found at path: " + "C:/dbizrepo/dbiz.aiAutomation/data/API_Data/" + jsonFileName);
		} catch (IOException e) {
			throw new RuntimeException("IOException while reading file: " + jsonFileName);
		}
		return body;
	}

	public <T> T getJsonAsPojo(String jsonFileName, Class<T> pojoClass) throws IOException {

			jsonFile = new File("C:/dbizrepo/dbiz.aiAutomation/data/API_Data/" + jsonFileName);
			if (!jsonFile.exists()) {
				throw new IllegalArgumentException("JSON file does not exist: " + jsonFileName);
			}
			
		
		return objectMapper.readValue(jsonFile, pojoClass);
	}

}
