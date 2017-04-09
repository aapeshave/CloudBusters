package com.blogit.repositories;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import com.blogit.pojo.Post;

@EnableScan
public interface PostRepository extends CrudRepository<Post, String> {
	
	List<Post> findByBlogID(String blogID);
}
