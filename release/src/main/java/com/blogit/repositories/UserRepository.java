package com.blogit.repositories;

import com.blogit.pojo.User;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ajinkya on 3/21/17.
 */
@EnableScan
public interface UserRepository extends CrudRepository<User, String> {
    List<User> findByLastName(String lastName);

    User findByUsernameAndPassword(String userName, String password);
}
