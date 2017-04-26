package com.blogit.service;

import com.blogit.entity.LoginEntity;
import com.blogit.pojo.User;

/**
 * Created by ameyutturkar on 3/29/17.
 */
public interface LoginService {
    /**
     * Validate a user account using signin entity
     *
     * @param loginEntity is received from UI
     * @return user account created
     */
    User validateUserAccount(LoginEntity loginEntity) throws Exception;
}
