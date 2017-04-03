package com.blogit.repositories;

import com.blogit.pojo.AccessToken;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ajinkya on 3/31/17.
 */
@EnableScan
public interface AccessTokensRepository extends CrudRepository<AccessToken, String> {
    List<AccessToken> findByRole(String role);
}
