package DataBinders;

import java.util.List;

public class NearbySearchResult {

	private geometry geometry;
	private String icon;
	private String id;
	private String name;
	private String reference;
	private List<String> types;
	private String vicinity;
	
	public geometry getGeometry() {
		return geometry;
	}
	
	public void setGeometry(geometry geo) {
		geometry = geo;
	}
	
	public String getIcon() {
		return icon;
	}
	
	public void setIcon(String ic) {
		icon = ic;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String i) {
		id = i;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public String getReference() {
		return reference;
	}
	
	public void setReference(String r) {
		reference = r;
	}
	
	public List<String> getTypes() {
		return types;
	}
	
	public void setTypes(List<String> t) {
		types = t;
	}
	
	public String getVicinity() {
		return vicinity;
	}
	
	public void setVicinity(String v) {
		vicinity = v;
	}
	
}