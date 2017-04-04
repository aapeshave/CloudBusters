package com.blogit.entity;


import com.blogit.encryptionUtils.EncryptionDecryptionAES;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class LoginEntity {

    private static final String SECRET_KEY = "1x00786";
    private static final String ALGO_NAME = "AES";

    private String username;
    private String password;

    EncryptionDecryptionAES eAES = new EncryptionDecryptionAES();

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
        try{
            String encPassword = eAES.encrypt(password);
            this.password = encPassword;
        }
        catch (Exception e)
        {

        }
    }

    // TODO: Write encryption and decryption algorithm. AES or DES.
    private String encrypt(String sValue) {
        return sValue;
    }

    private String decrypt(String sValue) {
        return sValue;
    }

}
