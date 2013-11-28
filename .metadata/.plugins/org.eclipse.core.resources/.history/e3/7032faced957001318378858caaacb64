package Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import DataBinders.TopNearbySearchResult;
import Http.Http;
import JSONParsers.ParseNearbySearch;

public class NearbySearch {

	public TopNearbySearchResult search(HashMap<String, String> params) throws Exception {
		Http http = new Http();
		String data = http.getData("search", params);
		
		/*
		 * Check Validity of required parameters
		 */
		List<String> requiredParams = new ArrayList<String>(Arrays.asList("key", "location", "sensor"));
		
		for(String param : requiredParams) {
			if (!params.containsKey(param)) {
				throw new Exception("Missing Required param: " + param);
			}
		}
		
		TopNearbySearchResult result = ParseNearbySearch.parse(data);
		return result;
	}
}
