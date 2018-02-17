
package com.white.josh.legacytommvn.models;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Response implements Serializable {

	@SerializedName("numFound")
	@Expose
	private Integer numFound;
	@SerializedName("start")
	@Expose
	private Integer start;
	@SerializedName("docs")
	@Expose
	private List<Doc> docs = null;
	private final static long serialVersionUID = 3805658099534013852L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Response() {
	}

	/**
	 * 
	 * @param start
	 * @param docs
	 * @param numFound
	 */
	public Response(Integer numFound, Integer start, List<Doc> docs) {
		super();
		this.numFound = numFound;
		this.start = start;
		this.docs = docs;
	}

	public Integer getNumFound() {
		return numFound;
	}

	public void setNumFound(Integer numFound) {
		this.numFound = numFound;
	}

	public Response withNumFound(Integer numFound) {
		this.numFound = numFound;
		return this;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Response withStart(Integer start) {
		this.start = start;
		return this;
	}

	public List<Doc> getDocs() {
		return docs;
	}

	public void setDocs(List<Doc> docs) {
		this.docs = docs;
	}

	public Response withDocs(List<Doc> docs) {
		this.docs = docs;
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("numFound", numFound).append("start", start).append("docs", docs)
				.toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(start).append(docs).append(numFound).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Response) == false) {
			return false;
		}
		Response rhs = ((Response) other);
		return new EqualsBuilder().append(start, rhs.start).append(docs, rhs.docs).append(numFound, rhs.numFound)
				.isEquals();
	}

	public String toDependancy() {
		StringBuffer dependancies = new StringBuffer();
		StringBuffer dependancy = new StringBuffer();
		for (Doc doc : docs) {
			dependancies.append(tag("dependency", dependancy.append(tag("groupId", doc.getG()))
															.append(tag("artifactId", doc.getA()))
															.append(tag("version", doc.getV()))
															.toString()));
										
		}
		return dependancies.toString();
	}

	private String tag(String tagName, String tagContent) {
		StringBuffer tag = new StringBuffer();
		tag.append("<")
		   .append(tagName)
		   .append(">")
		   .append(tagContent)
		   .append("<")
		   .append("/")
		   .append(tagName)
		   .append(">");
		return tag.toString();
	}

}
