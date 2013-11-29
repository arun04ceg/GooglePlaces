package DataBinders;

import java.util.List;

public class OpeningHours {

	private Boolean open_now;
	private List<Period> periods;

	public Boolean getOpen_now() {
		return open_now;
	}

	public void setOpen_now(Boolean open_now) {
		this.open_now = open_now;
	}

	/**
	 * @return the periods
	 */
	public List<Period> getPeriods() {
		return periods;
	}

	/**
	 * @param periods the periods to set
	 */
	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}
	
}
