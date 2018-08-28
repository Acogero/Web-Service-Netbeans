package com.tipiniquim.utils;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

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
