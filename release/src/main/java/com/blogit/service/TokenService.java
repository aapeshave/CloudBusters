package com.blogit.service;

import com.blogit.entity.SignupEntity;

/**
 * Created by ajinkya on 3/15/17.
 */
public interface TokenService {


    /**
     * Creates encrypted token for an user while sign up
     *
     * @param signupEntity is received from UI. Fields are used to create access token
     * @return encrypted token
     */
    String createAccessToken(SignupEntity signupEntity);
}
