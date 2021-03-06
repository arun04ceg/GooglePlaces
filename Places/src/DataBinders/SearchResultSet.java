package DataBinders;

import java.util.List;

public class SearchResultSet {

	private List<String> debug_info;
	private List<String> html_attributions;
	private String next_page_token;
	private List<SearchResult> results;
	private String status;
	/**
	 * @return the debug_info
	 */
	public List<String> getDebug_info() {
		return debug_info;
	}
	/**
	 * @param debug_info the debug_info to set
	 */
	public void setDebug_info(List<String> debug_info) {
		this.debug_info = debug_info;
	}
	/**
	 * @return the html_attributions
	 */
	public List<String> getHtml_attributions() {
		return html_attributions;
	}
	/**
	 * @param html_attributions the html_attributions to set
	 */
	public void setHtml_attributions(List<String> html_attributions) {
		this.html_attributions = html_attributions;
	}
	/**
	 * @return the next_page_token
	 */
	public String getNext_page_token() {
		return next_page_token;
	}
	/**
	 * @param next_page_token the next_page_token to set
	 */
	public void setNext_page_token(String next_page_token) {
		this.next_page_token = next_page_token;
	}
	/**
	 * @return the results
	 */
	public List<SearchResult> getResults() {
		return results;
	}
	/**
	 * @param results the results to set
	 */
	public void setResults(List<SearchResult> results) {
		this.results = results;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
