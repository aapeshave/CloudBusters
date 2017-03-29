package com.blogit.service.impl;

import com.blogit.entity.SignupEntity;
import com.blogit.pojo.User;
import com.blogit.repositories.UserRepository;
import com.blogit.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ajinkya on 3/27/17.
 */
@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String createUserAccount(SignupEntity signupEntity) {
        User toCreate = new User(signupEntity.getFirstName(),
                signupEntity.getLastName(),
                signupEntity.getUsername(),
                signupEntity.getPassword(),
                signupEntity.getEmail());

        User saved = userRepository.save(toCreate);
        if (saved != null) {
            return saved.getId();
        }
        return null;
    }
}
