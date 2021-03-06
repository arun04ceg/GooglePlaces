package Http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * This class makes Http connection to fetch data
 * @author arun
 *
 */
public class Http {
	
	private final static String USER_AGENT = "Chrome 30.0.1623.0";
	private final static String format = "json";
	private final static Map<String, String> ServiceMap = new HashMap<String, String>();
	static {
		ServiceMap.put("nearbysearch", "https://maps.googleapis.com/maps/api/place/nearbysearch/");
		ServiceMap.put("textsearch", "https://maps.googleapis.com/maps/api/place/textsearch/");
		ServiceMap.put("radarsearch", "https://maps.googleapis.com/maps/api/place/radarsearch/");
		ServiceMap.put("placedetails", "https://maps.googleapis.com/maps/api/place/details/");
		ServiceMap.put("placeautocomplete", "https://maps.googleapis.com/maps/api/place/autocomplete/");
		ServiceMap.put("queryautocomplete", "https://maps.googleapis.com/maps/api/place/queryautocomplete/");
		ServiceMap.put("geocode", "http://maps.googleapis.com/maps/api/geocode/");
	}
	
	/**
	 * This function creates a http function to fetch data from google.
	 * @param category
	 * @param params
	 * @return
	 * @throws IOException
	 */
	public String getData(String category, Map<String, String> params) throws IOException
	{
		String url = ServiceMap.get(category) + format + "?" + constructUrlFromMap(params);
		URL obj = new URL(url);
		
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		 
		int responseCode = con.getResponseCode();
		System.out.println("URL: " + url);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return response.toString();
	}
	
	/**
	 * This function constructs the final url if the params are sent
	 * @param params
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private String constructUrlFromMap(Map<String, String> params)
	{
		StringBuffer builder = new StringBuffer();
		for(Map.Entry<String, String> param : params.entrySet())
		{
			builder.append("&");
			builder.append(URLEncoder.encode(param.getKey()));
			builder.append("=");
			builder.append(URLEncoder.encode(param.getValue()));
		}
		return builder.toString();
	}
		
}
