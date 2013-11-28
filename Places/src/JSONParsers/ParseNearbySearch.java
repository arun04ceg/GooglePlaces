package JSONParsers;

import java.io.IOException;

import DataBinders.NearbySearchResultSet;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ParseNearbySearch {
	
	public static NearbySearchResultSet parse(String data) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		NearbySearchResultSet result = mapper.readValue(data, NearbySearchResultSet.class);
		return result;
	}
}