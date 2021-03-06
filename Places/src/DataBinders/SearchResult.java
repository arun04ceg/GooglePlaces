package DataBinders;

import java.util.List;

public class SearchResult {

	private List<Event> events;
	private String formatted_address;
	private geometry geometry;
	private String icon;
	private String id;
	private String name;
	private OpeningHours opening_hours;
	private List<Photo> photos;
	private Integer price_level;
	private Double rating;
	private String reference;
	private List<String> types;
	private String vicinity;

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(geometry geometry) {
		this.geometry = geometry;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OpeningHours getOpening_hours() {
		return opening_hours;
	}

	public void setOpening_hours(OpeningHours opening_hours) {
		this.opening_hours = opening_hours;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	/**
	 * @return the price_level
	 */
	public Integer getPrice_level() {
		return price_level;
	}

	/**
	 * @param price_level the price_level to set
	 */
	public void setPrice_level(Integer price_level) {
		this.price_level = price_level;
	}

	/**
	 * @return the vicinity
	 */
	public String getVicinity() {
		return vicinity;
	}

	/**
	 * @param vicinity the vicinity to set
	 */
	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}

	/**
	 * @return the events
	 */
	public List<Event> getEvents() {
		return events;
	}

	/**
	 * @param events the events to set
	 */
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
}
