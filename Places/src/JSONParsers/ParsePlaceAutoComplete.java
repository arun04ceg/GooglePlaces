package JSONParsers;

import java.io.IOException;

import DataBinders.PlaceAutoCompleteResultSet;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Parser for PlaceAutoComplete response
 * @author arun
 *
 */
public class ParsePlaceAutoComplete {

	public static PlaceAutoCompleteResultSet parse(String data) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		PlaceAutoCompleteResultSet result = mapper.readValue(data, PlaceAutoCompleteResultSet.class);
		return result;
	}
}
