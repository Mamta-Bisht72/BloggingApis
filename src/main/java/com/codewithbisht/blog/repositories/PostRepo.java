package com.codewithbisht.blog.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithbisht.blog.entities.Category;
import com.codewithbisht.blog.entities.Post;
import com.codewithbisht.blog.entities.User;


public interface PostRepo extends JpaRepository<Post,Integer> {

	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	List<Post> findByTitleContaining(String title);

	
}
