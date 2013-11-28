package Main;

import java.util.HashMap;

import DataBinders.TopNearbySearchResult;
import Query.NearbySearch;

public class Main {

	public static void main(String[] args) throws Exception {
		NearbySearch nearbySearch = new NearbySearch();
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("location", "40.7500,111.8833");
		params.put("radius", "100000");
		params.put("sensor", "false");
		params.put("key", "AIzaSyC8j9ERqf-XwxMpATEfO063jkfhvTINNcw");
		params.put("types", "hospital|health");
		TopNearbySearchResult result = nearbySearch.search(params);
		System.out.println(result.getResults().get(0).getTypes());
	}
}