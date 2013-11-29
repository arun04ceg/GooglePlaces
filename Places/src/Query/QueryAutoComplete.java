package Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import DataBinders.QueryAutocompleteResultSet;
import Http.Http;
import JSONParsers.ParseQueryAutoComplete;

public class QueryAutoComplete {

	public static QueryAutocompleteResultSet autoComplete(HashMap<String, String> params) throws Exception {
		Http http = new Http();
		String data = http.getData("queryautocomplete", params);
		
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
		
		QueryAutocompleteResultSet result = ParseQueryAutoComplete.parse(data);
		return result;
	}
}
