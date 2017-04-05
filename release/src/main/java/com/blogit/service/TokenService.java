package com.blogit.service;

import com.blogit.entity.SignupEntity;
import com.blogit.pojo.AccessToken;

/**
 * Created by ajinkya on 3/15/17.
 */

/**
 * Deals with service operations related to Access Tokens
 */
public interface TokenService {


    /**
     * Creates encrypted token for an user while sign up
     *
     * @param signupEntity is received from UI. Fields are used to create access token
     * @return encrypted token
     */
    AccessToken createAccessToken(SignupEntity signupEntity);

    /**
     * Get tokenInfo from the en
     *
     * @param encryptedTokenString value given to the user
     * @return the TokenInfo
     */
    TokenInfo getTokenInfo(String encryptedTokenString);

    /**
     * @param tokenToBeDeleted Object to be deleted
     * @return true if successfully deleted
     */
    Boolean deleteToken(AccessToken tokenToBeDeleted);

    /**
     * This class is used to send information about the Token
     */
    class TokenInfo {
        public String getTokenId;
        public String getTokenString;
        public String getUsername;
        public String getRole;
        public String getPassword;
        public String getUserId;
    }
}
