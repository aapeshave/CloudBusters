package com.blogit.service.impl;

import com.blogit.entity.SignupEntity;
import com.blogit.pojo.AccessToken;
import com.blogit.repositories.AccessTokensRepository;
import com.blogit.service.TokenService;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * Created by ajinkya on 3/15/17.
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    AccessTokensRepository tokenRepository;
    @Value("$token.secretKey")
    private String API_SECRET;

    @Override
    public String createAccessToken(SignupEntity signupEntity) {
        // TODO: Create a token over here and save it to DB. Use id for next purposes. Need role parameter.
        return null;
    }

    private AccessToken createAccessToken() {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(API_SECRET);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        return null;
    }
}
