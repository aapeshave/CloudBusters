package com.blogit.pojo;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.Date;

/**
 * Created by ajinkya on 3/15/17.
 */
@DynamoDBTable(tableName = "AccessToken")
public class AccessToken {

    private String id;
    private String tokenString;
    private String issuer;
    private String role;
    private String createdOn;
    private Long validTill;

    public AccessToken() {
    }

    public AccessToken(String tokenString, String issuer, String role, Long validTill) {
        this();
        this.tokenString = tokenString;
        this.issuer = issuer;
        this.role = role;
        this.validTill = validTill;
    }

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute
    public String getTokenString() {
        return tokenString;
    }

    public void setTokenString(String tokenString) {
        this.tokenString = tokenString;
    }

    @DynamoDBAttribute
    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    @DynamoDBAttribute
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @DynamoDBAutoGeneratedTimestamp
    public String getCreatedOn() {
        return createdOn;
    }

    @DynamoDBAttribute
    public Long getValidTill() {
        return validTill;
    }

    public void setValidTill(Long validTill) {
        this.validTill = validTill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccessToken)) return false;

        AccessToken that = (AccessToken) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tokenString != null ? !tokenString.equals(that.tokenString) : that.tokenString != null) return false;
        if (issuer != null ? !issuer.equals(that.issuer) : that.issuer != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (createdOn != null ? !createdOn.equals(that.createdOn) : that.createdOn != null) return false;
        return validTill != null ? validTill.equals(that.validTill) : that.validTill == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tokenString != null ? tokenString.hashCode() : 0);
        result = 31 * result + (issuer != null ? issuer.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (createdOn != null ? createdOn.hashCode() : 0);
        result = 31 * result + (validTill != null ? validTill.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "id='" + id + '\'' +
                ", tokenString='" + tokenString + '\'' +
                ", issuer='" + issuer + '\'' +
                ", role='" + role + '\'' +
                ", createdOn=" + createdOn +
                ", validTill=" + validTill +
                '}';
    }

    private Long getUnixTimestamp() {
        Long unixDate = new Date().getTime() / 1000;
        return unixDate;
    }
}
