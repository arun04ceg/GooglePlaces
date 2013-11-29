package DataBinders;

import java.util.List;

public class Review {
	private List<Aspect> aspects;
	private String author_name;
	private String author_url;
	private Integer rating;
	private String text;
	private String time;
	/**
	 * @return the aspects
	 */
	public List<Aspect> getAspects() {
		return aspects;
	}
	/**
	 * @param aspects the aspects to set
	 */
	public void setAspects(List<Aspect> aspects) {
		this.aspects = aspects;
	}
	/**
	 * @return the author_name
	 */
	public String getAuthor_name() {
		return author_name;
	}
	/**
	 * @param author_name the author_name to set
	 */
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	/**
	 * @return the author_url
	 */
	public String getAuthor_url() {
		return author_url;
	}
	/**
	 * @param author_url the author_url to set
	 */
	public void setAuthor_url(String author_url) {
		this.author_url = author_url;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the rating
	 */
	public Integer getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
