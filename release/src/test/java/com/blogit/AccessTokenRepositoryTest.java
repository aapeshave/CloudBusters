package com.blogit;

import com.blogit.pojo.AccessToken;
import com.blogit.repositories.AccessTokensRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by ajinkya on 3/31/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccessTokenRepositoryTest {
    @Autowired
    private AccessTokensRepository accessTokensRepository;

    @Test
    public void testAddAccessToken() throws Exception {
        AccessToken toCreate = new AccessToken("Encrypted_String",
                "Admin",
                "Reader",
                getNextYearDate());
        AccessToken saved = accessTokensRepository.save(toCreate);
        Assert.assertNotNull("Assert that token is created", saved);
        Thread.sleep(1000);
        String id = saved.getId();

        saved = accessTokensRepository.findOne(id);
        Assert.assertNotNull(saved);

        List<AccessToken> readers = accessTokensRepository.findByRole("Reader");
        Assert.assertNotNull("Assert that list is not null", readers);
        Assert.assertEquals("Assert that list contains only one element", 1, readers.size());

        accessTokensRepository.delete(saved);
    }

    private Date getNextYearDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 1);
        return cal.getTime();
    }
}
