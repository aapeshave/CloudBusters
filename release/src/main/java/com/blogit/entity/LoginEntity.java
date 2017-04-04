package com.blogit.entity;


import com.blogit.encryptionUtils.EncryptionDecryptionAES;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class LoginEntity {

    private EncryptionDecryptionAES eAES = new EncryptionDecryptionAES();
    private String username;
    private String password;

    public LoginEntity() throws NoSuchPaddingException, NoSuchAlgorithmException {

    }

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

        try {
            this.password = eAES.encrypt(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String encrypt(String sValue) {
        return sValue;
    }

    private String decrypt(String sValue) {
        return sValue;
    }

}
