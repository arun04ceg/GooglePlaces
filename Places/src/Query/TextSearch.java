package Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import DataBinders.TextSearchResultSet;
import Http.Http;
import JSONParsers.ParseTextSearch;

public class TextSearch {

	public TextSearchResultSet search(HashMap<String, String> params) throws Exception {
		Http http = new Http();
		String data = http.getData("textsearch", params);
		
		/*
		 * Check Validity of required parameters
		 */
		List<String> requiredParams = new ArrayList<String>(Arrays.asList("query", "key", "sensor"));
		
		for(String param : requiredParams) {
			if (!params.containsKey(param)) {
				throw new Exception("Missing Required param: " + param);
			}
		}
		
		TextSearchResultSet result = ParseTextSearch.parse(data);
		return result;
	}
}
