package com.blogit.service.impl;

import com.blogit.encryptionUtils.EncryptionDecryptionAES;
import com.blogit.entity.BlogEntity;
import com.blogit.entity.SignupEntity;
import com.blogit.pojo.AccessToken;
import com.blogit.pojo.User;
import com.blogit.repositories.UserRepository;
import com.blogit.service.BlogService;
import com.blogit.service.SignUpService;
import com.blogit.service.TokenService;
import org.apache.commons.lang3.StringUtils;
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

    @Autowired
    private BlogService blogService;

    public SignUpServiceImpl() throws NoSuchPaddingException, NoSuchAlgorithmException {
    }

    @Override
    public String createUserAccount(SignupEntity signupEntity) {
        User toCreate = new User(signupEntity.getFirstName(),
                signupEntity.getLastName(),
                signupEntity.getUsername(),
                eAES.decrypt(signupEntity.getPassword()),
                signupEntity.getEmail());

        if (userRepository.findByUsername(signupEntity.getUsername()).isEmpty()) {
            User saved = userRepository.save(toCreate);
            if (saved != null) {
                signupEntity.setId(saved.getId());
                createAccessTokenForUser(signupEntity, saved);
                if (StringUtils.isNotBlank(signupEntity.getBlogName())) {
                    createBlogForUser(signupEntity, saved);
                }
                userRepository.save(saved);
                return saved.getId();
            }
        }
        return null;
    }

    private void createBlogForUser(SignupEntity signupEntity, User saved) {
        BlogEntity blogEntity = new BlogEntity(signupEntity.getBlogName(), saved.getId());
        String createdBlogId = blogService.createBlog(blogEntity);
        signupEntity.setBlogId(createdBlogId);
    }

    private void createAccessTokenForUser(SignupEntity signupEntity, User saved) {
        AccessToken accessToken = tokenService.createAccessToken(signupEntity);
        saved.addToken(accessToken.getTokenString());
        signupEntity.setEncryptedToken(accessToken.getTokenString());
    }
}
