package Main;

import java.util.HashMap;

import DataBinders.NearbySearchResultSet;
import DataBinders.TextSearchResultSet;
import Query.NearbySearch;
import Query.TextSearch;

public class Main {

	public static void main(String[] args) throws Exception {
		NearbySearch nearbySearch = new NearbySearch();
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("location", "40.7500,111.8833");
		params.put("radius", "100000");
		params.put("sensor", "false");
		params.put("key", "AIzaSyC8j9ERqf-XwxMpATEfO063jkfhvTINNcw");
		params.put("types", "hospital|health");
		NearbySearchResultSet result = nearbySearch.search(params);
		System.out.println(result.getResults().get(0).getTypes());
		
		TextSearch textSearch = new TextSearch();
		params = new HashMap<String, String>();
		params.put("query", "restaurants in Sydney");
		params.put("sensor", "true");
		params.put("key", "AIzaSyC8j9ERqf-XwxMpATEfO063jkfhvTINNcw");
		TextSearchResultSet result1 = textSearch.search(params);
		System.out.println(result1.getStatus());
	}
}
