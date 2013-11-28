package JSONParsers;

import java.io.IOException;

import DataBinders.TopNearbySearchResult;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ParseNearbySearch {
	
	public static TopNearbySearchResult parse(String data) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		TopNearbySearchResult result = mapper.readValue(data, TopNearbySearchResult.class);
		return result;
	}
}