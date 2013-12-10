package JSONParsers;

import java.io.IOException;

import DataBinders.SearchResultSet;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Parser for search response
 * @author arun
 *
 */
public class ParseSearch {

	public static SearchResultSet parse(String data) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		SearchResultSet result = mapper.readValue(data, SearchResultSet.class);
		return result;
	}
}
