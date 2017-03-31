package com.blogit.repositories;

import com.blogit.pojo.AccessToken;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ajinkya on 3/31/17.
 */
public interface AccessTokensRepository extends CrudRepository<AccessToken, String> {
    String getByEncryptedToken(String tokenId);
}
