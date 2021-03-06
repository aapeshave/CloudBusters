package com.blogit.service.impl;

import com.blogit.encryptionUtils.EncryptionDecryptionAES;
import com.blogit.entity.LoginEntity;
import com.blogit.pojo.User;
import com.blogit.repositories.UserRepository;
import com.blogit.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ameyutturkar on 3/30/17.
 */
@Service
public class LoginServiceImpl implements LoginService{

    private EncryptionDecryptionAES encryptionUtils = new EncryptionDecryptionAES();
    @Autowired
    private UserRepository userRepository;

    public LoginServiceImpl() throws NoSuchPaddingException, NoSuchAlgorithmException {
    }

    public User validateUserAccount(LoginEntity loginEntity) throws Exception
    {
        if(StringUtils.isNotBlank(loginEntity.getUsername()) && StringUtils.isNotBlank(loginEntity.getPassword()))
        {
            User validated = userRepository.findByUsernameAndPassword(loginEntity.getUsername(), encryptionUtils.decrypt(loginEntity.getPassword()));
            return validated;
        }
        return null;
    }
}
