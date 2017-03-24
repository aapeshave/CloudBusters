package com.blogit.entity;

/**
 * Created by ameyutturkar on 3/15/17.
 */
public class SignupEntity
{
    private static final String SECRET_KEY = "1x00786";
    private static final String ALGO_NAME = "AES";

    private String username;
    private String password;
    private String email;
    private String location;
    private String blogName;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = encrypt(username);
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = encrypt(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    // TODO: Write encryption and decryption algorithm. AES or DES.
    private String encrypt(String sValue)
    {
        return sValue;
    }

    private String decrypt(String sValue)
    {
        return sValue;
    }
}