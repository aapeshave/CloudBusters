package com.blogit.encryptionUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

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
        return encryptedString;
    }

    public String decrypt(String encryptedText) {
        Base64.Decoder decoder = Base64.getDecoder();
        try {
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            return new String(cipher.doFinal(decoder.decode(encryptedText)));
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
