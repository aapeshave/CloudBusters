package com.blogit.encryptionUtils;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import static javax.crypto.KeyGenerator.*;

/**
 * Created by ameyutturkar on 4/3/17.
 */
public class EncryptionDecryptionAES {

    String key = "Bar12345Bar12345";
    Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
    Cipher cipher = Cipher.getInstance("AES");

    public EncryptionDecryptionAES() throws NoSuchPaddingException, NoSuchAlgorithmException {
    }

    public String encrypt(String plainText) throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        byte[] encrypted = cipher.doFinal(plainText.getBytes());
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedString = encoder.encodeToString(encrypted);
        System.out.println(encryptedString);
        return encryptedString;
    }

    public String decrypt(String encryptedText) throws Exception {
        Base64.Decoder decoder = Base64.getDecoder();
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        String decryptedString = new String(cipher.doFinal(decoder.decode(encryptedText)));
        System.out.println(decryptedString);
        return decryptedString;
    }
}
