package Main;

import java.util.HashMap;

import DataBinders.DetailsResultSet;
import DataBinders.PlaceAutoCompleteResultSet;
import DataBinders.QueryAutocompleteResultSet;
import DataBinders.SearchResultSet;
import Query.Details;
import Query.PlaceAutoComplete;
import Query.PlacePhoto;
import Query.QueryAutoComplete;
import Query.Search;

public class Main {

	public static void main(String[] args) throws Exception {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("location", "40.7500,111.8833");
		params.put("radius", "100000");
		params.put("sensor", "false");
		params.put("key", "AIzaSyC8j9ERqf-XwxMpATEfO063jkfhvTINNcw");
		params.put("types", "hospital|health");
		SearchResultSet result = Search.search("nearbysearch", params);
		System.out.println(result.getResults().get(0).getTypes());
		
		params = new HashMap<String, String>();
		params.put("query", "restaurants in Sydney");
		params.put("sensor", "true");
		params.put("key", "AIzaSyC8j9ERqf-XwxMpATEfO063jkfhvTINNcw");
		result = Search.search("textsearch", params);
		System.out.println(result.getResults().get(0).getName());
		
		params = new HashMap<String, String>();
		params.put("location", "51.503186,-0.126446");
		params.put("radius", "5000");
		params.put("types", "museum");
		params.put("sensor", "false");
		params.put("key", "AIzaSyC8j9ERqf-XwxMpATEfO063jkfhvTINNcw");
		result = Search.search("radarsearch", params);
		System.out.println(result.getResults().get(0).getId());
		
		params = new HashMap<String, String>();
		params.put("reference", "CmRYAAAAciqGsTRX1mXRvuXSH2ErwW-jCINE1aLiwP64MCWDN5vkXvXoQGPKldMfmdGyqWSpm7BEYCgDm-iv7Kc2PF7QA7brMAwBbAcqMr5i1f4PwTpaovIZjysCEZTry8Ez30wpEhCNCXpynextCld2EBsDkRKsGhSLayuRyFsex6JA6NPh9dyupoTH3g");
		params.put("sensor", "true");
		params.put("key", "AIzaSyC8j9ERqf-XwxMpATEfO063jkfhvTINNcw");
		DetailsResultSet result1= Details.details(params);
		System.out.println(result1.getResult().getInternational_phone_number());
		
		String url = PlacePhoto.getPhotoUrl("AIzaSyC8j9ERqf-XwxMpATEfO063jkfhvTINNcw", "CpQBgwAAABs8J_uTfYJalgC7WhdWbEvCqpTLHCKAFigb-KdvPWrKdL3UkXJpbeXBKyDZHUqKEakn9uDr8ujYNshwnWS01xYttULeOpYIJuqnvzL8_fSLUvwUEXO4-sHNeNQBf9_wNME797HCdbjbACqpttTUXj1Df54gyy0UeORNcfrjsDrJm0rTrUKc7E0JVAfmcNG5_hIQdMS9lT8bdfTKMI4yid2r-BoUGzu2DJif5ifCfiw7bXjvS_6S7AM", "true", "maxwidth", "400");
		System.out.println(url);
		
		params = new HashMap<String, String>();
		params.put("sensor", "true");
		params.put("key", "AIzaSyC8j9ERqf-XwxMpATEfO063jkfhvTINNcw");
		params.put("input", "salt la");
		PlaceAutoCompleteResultSet result2 = PlaceAutoComplete.autoComplete(params);
		System.out.println(result2.getPredictions().get(0).getDescription());

		params = new HashMap<String, String>();
		params.put("key", "AIzaSyC8j9ERqf-XwxMpATEfO063jkfhvTINNcw");
		params.put("sensor", "true");
		params.put("input", "pizza near par");
		QueryAutocompleteResultSet result3 = QueryAutoComplete.autoComplete(params);
		System.out.println(result3.getPredictions().get(0).getDescription());
		
	}
}
