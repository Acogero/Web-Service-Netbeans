package com.tipiniquim.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonUtils {
	private static ObjectMapper mapper = new ObjectMapper();

	public static String objectToJsonWithRootName( Object obj ) throws IOException {
		return mapper.writeValueAsString( obj );
	}

	public static String getValue( String json ) throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue( json, String.class );
	}

	public static ObjectMapper getObjectMapper() {
		return mapper;
	}
}
