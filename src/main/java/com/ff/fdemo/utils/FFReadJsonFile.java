package com.ff.fdemo.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ff.fdemo.model.FF000401Model;

public class FFReadJsonFile {
	private static String path = "/Users/jack/Documents/1_MMO/FDemo/src/main/resources/companies.json";

	public static List<FF000401Model> readJsonFile() throws JsonParseException,
			JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		List<FF000401Model> companies = (List<FF000401Model>) mapper.readValue(
				new File(path), new TypeReference<List<FF000401Model>>() {
				});
		return companies;
	}

	
}
