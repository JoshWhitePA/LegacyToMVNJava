
package com.white.josh.legacytommvn.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Params implements Serializable
{

    @SerializedName("q")
    @Expose
    private String q;
    @SerializedName("indent")
    @Expose
    private String indent;
    @SerializedName("fl")
    @Expose
    private String fl;
    @SerializedName("sort")
    @Expose
    private String sort;
    @SerializedName("rows")
    @Expose
    private String rows;
    @SerializedName("wt")
    @Expose
    private String wt;
    @SerializedName("version")
    @Expose
    private String version;
    private final static long serialVersionUID = 5654184431580092623L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Params() {
    }

    /**
     * 
     * @param sort
     * @param fl
     * @param indent
     * @param q
     * @param wt
     * @param version
     * @param rows
     */
    public Params(String q, String indent, String fl, String sort, String rows, String wt, String version) {
        super();
        this.q = q;
        this.indent = indent;
        this.fl = fl;
        this.sort = sort;
        this.rows = rows;
        this.wt = wt;
        this.version = version;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public Params withQ(String q) {
        this.q = q;
        return this;
    }

    public String getIndent() {
        return indent;
    }

    public void setIndent(String indent) {
        this.indent = indent;
    }

    public Params withIndent(String indent) {
        this.indent = indent;
        return this;
    }

    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public Params withFl(String fl) {
        this.fl = fl;
        return this;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Params withSort(String sort) {
        this.sort = sort;
        return this;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public Params withRows(String rows) {
        this.rows = rows;
        return this;
    }

    public String getWt() {
        return wt;
    }

    public void setWt(String wt) {
        this.wt = wt;
    }

    public Params withWt(String wt) {
        this.wt = wt;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Params withVersion(String version) {
        this.version = version;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("q", q).append("indent", indent).append("fl", fl).append("sort", sort).append("rows", rows).append("wt", wt).append("version", version).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sort).append(fl).append(indent).append(q).append(wt).append(version).append(rows).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Params) == false) {
            return false;
        }
        Params rhs = ((Params) other);
        return new EqualsBuilder().append(sort, rhs.sort).append(fl, rhs.fl).append(indent, rhs.indent).append(q, rhs.q).append(wt, rhs.wt).append(version, rhs.version).append(rows, rhs.rows).isEquals();
    }

}
