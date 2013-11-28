package DataBinders;

import java.util.List;

public class NearbySearchResultSet {

	private List<String> debug_info;
	private List<String> html_attributions;
	private String next_page_token;
	private List<NearbySearchResult> results;
	private String status;
	
	public void setDebug_info(List<String> d) {
		debug_info = d;
	}
	
	public List<String> getDebug_info() {
		return debug_info;
	}
	
	public void setHtml_attributions(List<String> h) {
		html_attributions = h;
	}
	
	public List<String> getHtml_attributions() {
		return html_attributions;
	}
	
	public String getNext_page_token() {
		return next_page_token;
	}
	
	public void setNext_page_token(String n) {
		next_page_token = n;
	}
	
	public List<NearbySearchResult> getResults() {
		return results;
	}
	
	public void setResults(List<NearbySearchResult> r) {
		results = r;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String s) {
		status = s;
	}
}
