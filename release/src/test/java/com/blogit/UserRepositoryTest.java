package com.blogit;

import com.blogit.pojo.User;
import com.blogit.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ajinkya on 3/21/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void testAddUser() throws Exception {
        List<String> tokens = new ArrayList<>();
        tokens.add("Sample Token 1");

        User dave = new User("Dave", "Matthews");
        dave.setAccessTokens(tokens);
        repository.save(dave);

        User carter = new User("Carter", "Beauford");

        carter.setAccessTokens(tokens);
        repository.save(carter);

        List<User> result = repository.findByLastName("Matthews");
        Assert.assertNotNull("Assert that result is not empty", result);

        for (User user : result) {
            System.out.println(user);
        }
        repository.delete(result);
    }

    @Test
    public void testSearchByUsernameAndPassword() throws Exception {
        User user = new User("Dave", "Matthews", "dave", "admin", "dave@example.com");
        repository.save(user);

        User result = repository.findByUsernameAndPassword("dave", "admin");
        Assert.assertNotNull(result);
        Assert.assertEquals("Assert that password is admin", user.getPassword(), "admin");

        repository.delete(user);
    }
}
