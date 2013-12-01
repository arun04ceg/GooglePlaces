package DataBinders;

import java.util.List;

public class GeoCodeResultSet {
	List<GeoCodeResult> results;
	String status;
	
	/**
	 * @return the results
	 */
	public List<GeoCodeResult> getResults() {
		return results;
	}
	/**
	 * @param results the results to set
	 */
	public void setResults(List<GeoCodeResult> results) {
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
