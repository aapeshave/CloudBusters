package com.blogit.service.impl;

import com.blogit.encryptionUtils.EncryptionDecryptionAES;
import com.blogit.entity.SignupEntity;
import com.blogit.pojo.AccessToken;
import com.blogit.pojo.User;
import com.blogit.repositories.UserRepository;
import com.blogit.service.SignUpService;
import com.blogit.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ajinkya on 3/27/17.
 */
@Service
public class SignUpServiceImpl implements SignUpService {

    EncryptionDecryptionAES eAES = new EncryptionDecryptionAES();
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;

    public SignUpServiceImpl() throws NoSuchPaddingException, NoSuchAlgorithmException {
    }

    @Override
    public String createUserAccount(SignupEntity signupEntity) throws Exception {
        User toCreate = new User(signupEntity.getFirstName(),
                signupEntity.getLastName(),
                signupEntity.getUsername(),
                eAES.decrypt(signupEntity.getPassword()),
                signupEntity.getEmail());

        User saved = userRepository.save(toCreate);
        if (saved != null) {
            signupEntity.setId(saved.getId());
            AccessToken accessToken = tokenService.createAccessToken(signupEntity);
            saved.addToken(accessToken.getTokenString());
            signupEntity.setEncryptedToken(accessToken.getTokenString());
            userRepository.save(saved);
            return saved.getId();
        }
        return null;
    }
}
