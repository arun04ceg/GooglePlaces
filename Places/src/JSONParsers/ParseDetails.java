package JSONParsers;

import java.io.IOException;

import DataBinders.DetailsResultSet;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Parser for Details response
 * @author arun
 *
 */
public class ParseDetails {

	public static DetailsResultSet parse(String data) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		DetailsResultSet result = mapper.readValue(data, DetailsResultSet.class);
		return result;
	}
}
