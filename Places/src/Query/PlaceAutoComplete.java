package Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import DataBinders.PlaceAutoCompleteResultSet;
import Http.Http;
import JSONParsers.ParsePlaceAutoComplete;

/**
 * Requester class for PlaceAutoComplte
 * @author arun
 *
 */
public class PlaceAutoComplete {

	public static PlaceAutoCompleteResultSet autoComplete(HashMap<String, String> params) throws Exception {
		Http http = new Http();
		String data = http.getData("placeautocomplete", params);
		
		/*
		 * Check Validity of required parameters
		 */
		List<String> requiredParams;
		requiredParams = new ArrayList<String>(Arrays.asList("input", "key", "sensor"));
		for(String param : requiredParams) {
			if (!params.containsKey(param)) {
				throw new Exception("Missing Required param: " + param);
			}
		}
		
		PlaceAutoCompleteResultSet result = ParsePlaceAutoComplete.parse(data);
		return result;
	}
}
