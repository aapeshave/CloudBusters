package com.blogit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.blogit.pojo.Post;

public interface PostRepository extends CrudRepository<Post, String> {
	List<Post> findByLastName(String postID);
}
