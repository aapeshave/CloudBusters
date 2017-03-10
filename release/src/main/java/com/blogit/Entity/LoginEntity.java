package com.blogit.Entity;


public class LoginEntity {

    private static final String SECRET_KEY = "1x00786";
    private static final String ALGO_NAME = "AES";

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = encrypt(username);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = encrypt(password);
    }

    // TODO: Write encryption and decryption algorithm. AES or DES.
    private String encrypt(String sValue) {
        return sValue;
    }

    private String decrypt(String sValue) {
        return sValue;
    }

}
