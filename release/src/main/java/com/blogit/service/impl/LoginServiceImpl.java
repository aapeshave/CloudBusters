package com.blogit.service.impl;

import com.blogit.entity.LoginEntity;
import com.blogit.pojo.User;
import com.blogit.repositories.UserRepository;
import com.blogit.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ameyutturkar on 3/30/17.
 */
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserRepository userRepository;

    public User validateUserAccount(LoginEntity loginEntity)
    {
        if(StringUtils.isNotBlank(loginEntity.getUsername()) && StringUtils.isNotBlank(loginEntity.getPassword()))
        {
            User validate = userRepository.findByUsernameAndPassword(loginEntity.getUsername(), loginEntity.getPassword());
            return validate;
        }
        return null;
    }
}
