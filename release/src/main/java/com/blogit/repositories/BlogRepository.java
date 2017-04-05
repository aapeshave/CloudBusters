package com.blogit.repositories;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.blogit.pojo.Blog;

@EnableScan
public interface BlogRepository extends CrudRepository<Blog, String> {
	
	List<Blog> findByUserID(String userID);

}
