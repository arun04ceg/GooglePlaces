package Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import DataBinders.DetailsResultSet;
import Http.Http;
import JSONParsers.ParseDetails;

/**
 * Requester class for Details Result set
 * @author arun
 *
 */
public class Details {

	public static DetailsResultSet details(HashMap<String, String> params) throws Exception {
		Http http = new Http();
		String data = http.getData("placedetails", params);
		
		/*
		 * Check Validity of required parameters
		 */
		List<String> requiredParams;
		requiredParams = new ArrayList<String>(Arrays.asList("key", "reference", "sensor"));
		for(String param : requiredParams) {
			if (!params.containsKey(param)) {
				throw new Exception("Missing Required param: " + param);
			}
		}
		
		DetailsResultSet result = ParseDetails.parse(data);
		return result;
	}
}
