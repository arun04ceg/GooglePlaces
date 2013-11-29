package DataBinders;

import java.util.List;

public class Prediction {

	private String description;
	private String reference;
	private String id;
	private List<term> terms;
	private List<MatchedSubStrings> matched_substrings;
	private List<String> types;
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}
	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the terms
	 */
	public List<term> getTerms() {
		return terms;
	}
	/**
	 * @param terms the terms to set
	 */
	public void setTerms(List<term> terms) {
		this.terms = terms;
	}
	/**
	 * @return the matched_substrings
	 */
	public List<MatchedSubStrings> getMatched_substrings() {
		return matched_substrings;
	}
	/**
	 * @param matched_substrings the matched_substrings to set
	 */
	public void setMatched_substrings(List<MatchedSubStrings> matched_substrings) {
		this.matched_substrings = matched_substrings;
	}
	/**
	 * @return the types
	 */
	public List<String> getTypes() {
		return types;
	}
	/**
	 * @param types the types to set
	 */
	public void setTypes(List<String> types) {
		this.types = types;
	}
	
	
}
