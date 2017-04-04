package com.blogit.service;

import com.blogit.entity.SignupEntity;

/**
 * Created by ajinkya on 3/27/17.
 */
public interface SignUpService {
    /**
     * Create an user account using signup entity
     *
     * @param signupEntity is received from UI
     * @return id of the user account created
     */
    String createUserAccount(SignupEntity signupEntity) throws Exception;
}
