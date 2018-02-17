
package com.white.josh.legacytommvn.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ResponseHeader implements Serializable
{

    @SerializedName("status")
    @Expose
    private Double status;
    @SerializedName("QTime")
    @Expose
    private Double qTime;
    @SerializedName("params")
    @Expose
    private Params params;
    private final static long serialVersionUID = 7509427481043821352L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResponseHeader() {
    }

    /**
     * 
     * @param qTime
     * @param status
     * @param params
     */
    public ResponseHeader(Double status, Double qTime, Params params) {
        super();
        this.status = status;
        this.qTime = qTime;
        this.params = params;
    }

    public Double getStatus() {
        return status;
    }

    public void setStatus(Double status) {
        this.status = status;
    }

    public ResponseHeader withStatus(Double status) {
        this.status = status;
        return this;
    }

    public Double getQTime() {
        return qTime;
    }

    public void setQTime(Double qTime) {
        this.qTime = qTime;
    }

    public ResponseHeader withQTime(Double qTime) {
        this.qTime = qTime;
        return this;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public ResponseHeader withParams(Params params) {
        this.params = params;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("status", status).append("qTime", qTime).append("params", params).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(qTime).append(status).append(params).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResponseHeader) == false) {
            return false;
        }
        ResponseHeader rhs = ((ResponseHeader) other);
        return new EqualsBuilder().append(qTime, rhs.qTime).append(status, rhs.status).append(params, rhs.params).isEquals();
    }

}
