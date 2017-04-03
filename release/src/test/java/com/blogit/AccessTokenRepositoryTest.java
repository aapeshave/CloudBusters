package com.blogit;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.*;
import com.blogit.pojo.AccessToken;
import com.blogit.repositories.AccessTokensRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by ajinkya on 3/31/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccessTokenRepositoryTest {
    private static final String KEY_NAME = "id";
    private static final Long READ_CAPACITY_UNITS = 5L;
    private static final Long WRITE_CAPACITY_UNITS = 5L;


    @Autowired
    private AccessTokensRepository accessTokensRepository;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Before
    public void setUp() throws Exception {
        amazonDynamoDB.deleteTable("AccessToken");

        List<AttributeDefinition> attributeDefinitions = new ArrayList<AttributeDefinition>();
        attributeDefinitions.add(new AttributeDefinition().withAttributeName(KEY_NAME).withAttributeType("S"));

        List<KeySchemaElement> keySchemaElements = new ArrayList<>();
        keySchemaElements.add(new KeySchemaElement().withAttributeName(KEY_NAME).withKeyType(KeyType.HASH));

        CreateTableRequest request = new CreateTableRequest()
                .withTableName("AccessToken")
                .withKeySchema(keySchemaElements)
                .withAttributeDefinitions(attributeDefinitions)
                .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(READ_CAPACITY_UNITS)
                        .withWriteCapacityUnits(WRITE_CAPACITY_UNITS));

        amazonDynamoDB.createTable(request);
    }

    @Test
    public void testAddAccessToken() throws Exception {
        AccessToken toCreate = new AccessToken("Encrypted_String",
                "Admin",
                "Reader",
                getUnixTimestamp(getNextYearDate()));
        AccessToken saved = accessTokensRepository.save(toCreate);
        Assert.assertNotNull("Assert that token is created", saved);
        Thread.sleep(1000);
        String id  =  saved.getId();

        saved = accessTokensRepository.findOne(id);
        Assert.assertNotNull(saved);
        int i =0;
        // List<AccessToken> readers = accessTokensRepository.findByRole("Reader");
        // Assert.assertNotNull("Assert that list is not null", readers);
        // Assert.assertEquals("Assert that list contains only one element", 1, readers.size());

        // accessTokensRepository.delete(saved);
    }

    private Date getNextYearDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 1);
        return cal.getTime();
    }

    private Long getUnixTimestamp(Date date) {
        Long unixDate = date.getTime() / 1000;
        return unixDate;
    }
}
