package DataBinders;

import java.util.List;

public class DetailsResultSet {

	private List<String> debug_info;
	private List<String> html_attributions;
	private DetailsResult result;
	private String status;
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
	 * @return the result
	 */
	public DetailsResult getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(DetailsResult result) {
		this.result = result;
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

}

