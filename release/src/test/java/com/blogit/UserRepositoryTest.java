package com.blogit;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.*;
import com.blogit.pojo.User;
import com.blogit.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
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
@Ignore
public class UserRepositoryTest {
    private static final String KEY_NAME = "id";
    private static final Long READ_CAPACITY_UNITS = 5L;
    private static final Long WRITE_CAPACITY_UNITS = 5L;

    @Autowired
    UserRepository repository;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;


    @Before
    public void setup() throws Exception {
        ListTablesResult listTablesResult = amazonDynamoDB.listTables();

        List<String> tableNames = listTablesResult.getTableNames();

        for (String table : tableNames) {
            amazonDynamoDB.deleteTable(table);
        }

        List<AttributeDefinition> attributeDefinitions = new ArrayList<AttributeDefinition>();
        attributeDefinitions.add(new AttributeDefinition().withAttributeName(KEY_NAME).withAttributeType("S"));

        List<KeySchemaElement> keySchemaElements = new ArrayList<KeySchemaElement>();
        keySchemaElements.add(new KeySchemaElement().withAttributeName(KEY_NAME).withKeyType(KeyType.HASH));

        for (String table : tableNames) {
            CreateTableRequest request = new CreateTableRequest()
                    .withTableName(table)
                    .withKeySchema(keySchemaElements)
                    .withAttributeDefinitions(attributeDefinitions)
                    .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(READ_CAPACITY_UNITS)
                            .withWriteCapacityUnits(WRITE_CAPACITY_UNITS));

            amazonDynamoDB.createTable(request);
        }

        listTablesResult = amazonDynamoDB.listTables();
        System.out.println(listTablesResult);
    }

    @Test
    public void testAddUser() throws Exception {
        User dave = new User("Dave", "Matthews");
        repository.save(dave);

        User carter = new User("Carter", "Beauford");
        repository.save(carter);

        List<User> result = repository.findByLastName("Matthews");
        Assert.assertNotNull("Assert that result is not empty", result);

        for (User user : result) {
            System.out.println(user);
        }
    }

    @Test
    public void testSearchByUsernameAndPassword() throws Exception {
        User user = new User("Dave", "Matthews", "dave", "admin", "dave@example.com");
        repository.save(user);

        User result = repository.findByUsernameAndPassword("dave", "admin");
        Assert.assertNotNull(result);
        Assert.assertEquals("Assert that password is admin", user.getPassword(), "admin");
    }
}
