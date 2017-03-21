package com.blogit.pojo;

import java.util.Date;

/**
 * Created by ajinkya on 3/15/17.
 */
public class AccessToken {
    private String tokenId;
    private String tokenUid;
    private String issuer;
    private String accessUrl;
    private String role;
    private String objectName;
    private Date createdOn;
    private Date validTill;

    public AccessToken(String issuer, String accessUrl, String role, String objectName, Date createdOn, Date validTill) {
        this.issuer = issuer;
        this.accessUrl = accessUrl;
        this.role = role;
        this.objectName = objectName;
        this.createdOn = createdOn;
        this.validTill = validTill;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getTokenUid() {
        return tokenUid;
    }

    public void setTokenUid(String tokenUid) {
        this.tokenUid = tokenUid;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getAccessUrl() {
        return accessUrl;
    }

    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getValidTill() {
        return validTill;
    }

    public void setValidTill(Date validTill) {
        this.validTill = validTill;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "tokenId='" + tokenId + '\'' +
                ", tokenUid='" + tokenUid + '\'' +
                ", issuer='" + issuer + '\'' +
                ", accessUrl='" + accessUrl + '\'' +
                ", role='" + role + '\'' +
                ", objectName='" + objectName + '\'' +
                ", createdOn=" + createdOn +
                ", validTill=" + validTill +
                '}';
    }
}
