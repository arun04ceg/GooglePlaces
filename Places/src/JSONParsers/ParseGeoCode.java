package JSONParsers;

import java.io.IOException;

import DataBinders.GeoCodeResultSet;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Parser for GeoCode respose
 * @author arun
 *
 */
public class ParseGeoCode {

	public static GeoCodeResultSet parse(String data) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		GeoCodeResultSet result = mapper.readValue(data, GeoCodeResultSet.class);
		return result;
	}
}