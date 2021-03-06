package DataBinders;

import java.util.List;


public class GeoCodeResult {
	private List<AddressComponent> address_components ;
	private String formatted_address;
	private geometry geometry;
	
	/**
	 * @return the address_components
	 */
	public List<AddressComponent> getAddress_components() {
		return address_components;
	}
	/**
	 * @param address_components the address_components to set
	 */
	public void setAddress_components(List<AddressComponent> address_components) {
		this.address_components = address_components;
	}
	/**
	 * @return the formatted_address
	 */
	public String getFormatted_address() {
		return formatted_address;
	}
	/**
	 * @param formatted_address the formatted_address to set
	 */
	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}
	/**
	 * @return the geometry
	 */
	public geometry getGeometry() {
		return geometry;
	}
	/**
	 * @param geometry the geometry to set
	 */
	public void setGeometry(geometry geometry) {
		this.geometry = geometry;
	}

}
