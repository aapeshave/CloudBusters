package com.blogit;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.blogit.repositories.BlogRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogRepositoryTest {
	
	@Autowired
    private BlogRepository repository;

}
