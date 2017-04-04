package com.blogit.service.impl;

import com.blogit.entity.SignupEntity;
import com.blogit.pojo.AccessToken;
import com.blogit.repositories.AccessTokensRepository;
import com.blogit.service.TokenService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ajinkya on 4/4/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TokenServiceImplTest {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private AccessTokensRepository accessTokensRepository;

    private SignupEntity signupEntity;

    @Before
    public void setUp() throws Exception {
        signupEntity = new SignupEntity();
        signupEntity.setRole("Blogger");
        signupEntity.setBlogName("Test_Blog");
        signupEntity.setEmail("Test_email@example.com");
        signupEntity.setUsername("Test_username");
        signupEntity.setPassword("Test_password");
    }

    @Test
    public void createAccessToken() throws Exception {
        AccessToken accessToken = tokenService.createAccessToken(signupEntity);
        Assert.assertNotNull("Assert that token is created", accessToken);
        accessTokensRepository.delete(accessToken);
    }

    @Test
    public void testGetAccessTokenInfo() throws Exception {
        AccessToken accessToken = tokenService.createAccessToken(signupEntity);
        Assert.assertNotNull("Assert that token is created", accessToken);
        accessTokensRepository.delete(accessToken);

        TokenService.TokenInfo tokenInfo = tokenService.getTokenInfo(accessToken.getTokenString());
        Assert.assertNotNull("Assert that token info is created", tokenInfo);
        Assert.assertEquals("Assert that token Strings are same",
                tokenInfo.getTokenString,
                accessToken.getTokenString());

        Boolean result = tokenService.deleteToken(accessToken);
        Assert.assertTrue("Assert that token is deleted", result);
    }

}