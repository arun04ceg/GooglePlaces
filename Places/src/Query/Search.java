package Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import DataBinders.SearchResultSet;
import Http.Http;
import JSONParsers.ParseSearch;

/**
 * Requester class for search
 * @author arun
 *
 */
public class Search {

	public static SearchResultSet search(String SearchType, HashMap<String, String> params) throws Exception {
		Http http = new Http();
		String data = http.getData(SearchType, params);
		
		/*
		 * Check Validity of required parameters
		 */
		List<String> requiredParams;
		if(SearchType == "nearbysearch")
			requiredParams = new ArrayList<String>(Arrays.asList("location", "key", "sensor"));
		else if(SearchType == "textsearch")
			requiredParams = new ArrayList<String>(Arrays.asList("query", "key", "sensor"));
		else
			requiredParams = new ArrayList<String>(Arrays.asList("location", "key", "sensor", "radius"));
		for(String param : requiredParams) {
			if (!params.containsKey(param)) {
				throw new Exception("Missing Required param: " + param);
			}
		}
		
		SearchResultSet result = ParseSearch.parse(data);
		return result;
	}
}
