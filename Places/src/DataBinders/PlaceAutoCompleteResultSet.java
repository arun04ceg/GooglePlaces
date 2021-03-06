package DataBinders;

import java.util.List;

public class PlaceAutoCompleteResultSet {

	private String status;
	private List<Prediction> predictions;
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
	 * @return the predictions
	 */
	public List<Prediction> getPredictions() {
		return predictions;
	}
	/**
	 * @param predictions the predictions to set
	 */
	public void setPredictions(List<Prediction> predictions) {
		this.predictions = predictions;
	}
}
