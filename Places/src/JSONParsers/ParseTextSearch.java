package JSONParsers;

import java.io.IOException;

import DataBinders.TextSearchResultSet;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParseTextSearch {

	public static TextSearchResultSet parse(String data) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		TextSearchResultSet result = mapper.readValue(data, TextSearchResultSet.class);
		return result;
	}
}
