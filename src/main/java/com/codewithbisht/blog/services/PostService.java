package com.codewithbisht.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codewithbisht.blog.entities.Post;
import com.codewithbisht.blog.payloads.PostDto;
import com.codewithbisht.blog.payloads.PostResponse;

public interface PostService {

	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	PostDto updatePost(PostDto postDto,Integer postId);
	void deletePost(Integer postId);
	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
	PostDto getPostById(Integer postId);
	List<PostDto> getPostByCategory(Integer categoryId);
	List<PostDto> getPostsByUser(Integer userId);
	List<PostDto> searchPosts(String keyword);

	
}
