package Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import DataBinders.GeoCodeResultSet;
import Http.Http;
import JSONParsers.ParseGeoCode;

/**
 * Requester class for GeoCode
 * @author arun
 *
 */
public class GeoCode {
	
	public static GeoCodeResultSet getLatLong(HashMap<String, String> params) throws Exception {
		Http http = new Http();
		String data = http.getData("geocode", params);
		
		/*
		 * Check Validity of required parameters
		 */
		List<String> requiredParams;
		requiredParams = new ArrayList<String>(Arrays.asList("address", "sensor"));
		for(String param : requiredParams) {
			if (!params.containsKey(param)) {
				throw new Exception("Missing Required param: " + param);
			}
		}
		
		GeoCodeResultSet result = ParseGeoCode.parse(data);
		return result;
	}

}
