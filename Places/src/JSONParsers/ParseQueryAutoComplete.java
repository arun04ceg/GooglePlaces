package JSONParsers;

import java.io.IOException;

import DataBinders.QueryAutocompleteResultSet;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Parser for QueryAutocomplete response
 * @author arun
 *
 */
public class ParseQueryAutoComplete {

	public static QueryAutocompleteResultSet parse(String data) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		QueryAutocompleteResultSet result = mapper.readValue(data, QueryAutocompleteResultSet.class);
		return result;
	}
}
