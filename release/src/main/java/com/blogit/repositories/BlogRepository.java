package com.blogit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.blogit.pojo.Blog;

public interface BlogRepository extends CrudRepository<Blog, String> {
	
	List<Blog> findByLastName(String blogID);

}
