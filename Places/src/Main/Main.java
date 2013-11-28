package Main;

import java.util.HashMap;

import DataBinders.SearchResultSet;
import Query.Search;

public class Main {

	public static void main(String[] args) throws Exception {
		Search search = new Search();
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("location", "40.7500,111.8833");
		params.put("radius", "100000");
		params.put("sensor", "false");
		params.put("key", "AIzaSyC8j9ERqf-XwxMpATEfO063jkfhvTINNcw");
		params.put("types", "hospital|health");
		SearchResultSet result = search.search("nearbysearch", params);
		System.out.println(result.getResults().get(0).getTypes());
		
		params = new HashMap<String, String>();
		params.put("query", "restaurants in Sydney");
		params.put("sensor", "true");
		params.put("key", "AIzaSyC8j9ERqf-XwxMpATEfO063jkfhvTINNcw");
		result = search.search("textsearch", params);
		System.out.println(result.getResults().get(0).getName());
		
		params = new HashMap<String, String>();
		params.put("location", "51.503186,-0.126446");
		params.put("radius", "5000");
		params.put("types", "museum");
		params.put("sensor", "false");
		params.put("key", "AIzaSyC8j9ERqf-XwxMpATEfO063jkfhvTINNcw");
		result = search.search("radarsearch", params);
		System.out.println(result.getResults().get(0).getId());
	}
}
