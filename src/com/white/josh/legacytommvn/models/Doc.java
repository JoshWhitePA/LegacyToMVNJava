
package com.white.josh.legacytommvn.models;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Doc implements Serializable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("g")
    @Expose
    private String g;
    @SerializedName("a")
    @Expose
    private String a;
    @SerializedName("v")
    @Expose
    private String v;
    @SerializedName("p")
    @Expose
    private String p;
    @SerializedName("timestamp")
    @Expose
    private Double timestamp;
    @SerializedName("ec")
    @Expose
    private List<String> ec = null;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    private final static long serialVersionUID = -957025319560345928L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Doc() {
    }

    /**
     * 
     * @param tags
     * @param timestamp
     * @param id
     * @param v
     * @param g
     * @param p
     * @param a
     * @param ec
     */
    public Doc(String id, String g, String a, String v, String p, Double timestamp, List<String> ec, List<String> tags) {
        super();
        this.id = id;
        this.g = g;
        this.a = a;
        this.v = v;
        this.p = p;
        this.timestamp = timestamp;
        this.ec = ec;
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Doc withId(String id) {
        this.id = id;
        return this;
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }

    public Doc withG(String g) {
        this.g = g;
        return this;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public Doc withA(String a) {
        this.a = a;
        return this;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public Doc withV(String v) {
        this.v = v;
        return this;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public Doc withP(String p) {
        this.p = p;
        return this;
    }

    public Double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }

    public Doc withTimestamp(Double timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public List<String> getEc() {
        return ec;
    }

    public void setEc(List<String> ec) {
        this.ec = ec;
    }

    public Doc withEc(List<String> ec) {
        this.ec = ec;
        return this;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Doc withTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("g", g).append("a", a).append("v", v).append("p", p).append("timestamp", timestamp).append("ec", ec).append("tags", tags).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(tags).append(timestamp).append(id).append(v).append(g).append(p).append(a).append(ec).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Doc) == false) {
            return false;
        }
        Doc rhs = ((Doc) other);
        return new EqualsBuilder().append(tags, rhs.tags).append(timestamp, rhs.timestamp).append(id, rhs.id).append(v, rhs.v).append(g, rhs.g).append(p, rhs.p).append(a, rhs.a).append(ec, rhs.ec).isEquals();
    }

}
