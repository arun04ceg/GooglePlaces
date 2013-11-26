import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class Http {
	
	private final static String USER_AGENT = "Chrome 30.0.1623.0";
	private final static String format = "json";
	private final static Map<String, String> ServiceMap = new HashMap<String, String>();
	static {
		ServiceMap.put("search", "https://maps.googleapis.com/maps/api/place/search/");
	}
	
	public String getData(String category, Map<String, String> params) throws IOException
	{
		String url = ServiceMap.get(category) + format + "?" + constructUrlFromMap(params);
		URL obj = new URL(url);
		
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		 
		int responseCode = con.getResponseCode();
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
	
	private String constructUrlFromMap(Map<String, String> params)
	{
		StringBuffer builder = new StringBuffer();
		for(Map.Entry<String, String> param : params.entrySet())
		{
			builder.append(param.getKey());
			builder.append("=");
			builder.append(param.getValue());
		}
		return builder.toString();
	}
		
}