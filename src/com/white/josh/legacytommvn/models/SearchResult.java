
package com.white.josh.legacytommvn.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SearchResult implements Serializable {

	@SerializedName("responseHeader")
	@Expose
	private ResponseHeader responseHeader;
	@SerializedName("response")
	@Expose
	private Response response;
	private final static long serialVersionUID = -525577972505853001L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public SearchResult() {
	}

	/**
	 * 
	 * @param response
	 * @param responseHeader
	 */
	public SearchResult(ResponseHeader responseHeader, Response response) {
		super();
		this.responseHeader = responseHeader;
		this.response = response;
	}

	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

	public SearchResult withResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
		return this;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public SearchResult withResponse(Response response) {
		this.response = response;
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("responseHeader", responseHeader).append("response", response)
				.toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(response).append(responseHeader).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof SearchResult) == false) {
			return false;
		}
		SearchResult rhs = ((SearchResult) other);
		return new EqualsBuilder().append(response, rhs.response).append(responseHeader, rhs.responseHeader).isEquals();
	}

}
