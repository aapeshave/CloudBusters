package com.blogit.service.impl;

import com.blogit.encryptionUtils.EncryptionDecryptionAES;
import com.blogit.entity.SignupEntity;
import com.blogit.pojo.User;
import com.blogit.repositories.UserRepository;
import com.blogit.service.SignUpService;
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

    public SignUpServiceImpl() throws NoSuchPaddingException, NoSuchAlgorithmException {
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public String createUserAccount(SignupEntity signupEntity) throws Exception {
        User toCreate = new User(signupEntity.getFirstName(),
                signupEntity.getLastName(),
                signupEntity.getUsername(),
                eAES.decrypt(signupEntity.getPassword()),
                signupEntity.getEmail());

        User saved = userRepository.save(toCreate);
        if (saved != null) {
            return saved.getId();
        }
        return null;
    }
}
