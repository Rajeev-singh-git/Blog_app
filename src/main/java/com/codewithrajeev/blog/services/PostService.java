package com.codewithrajeev.blog.services;

import java.util.List;

import com.codewithrajeev.blog.entities.Post;
import com.codewithrajeev.blog.payloads.PostDto;

public interface PostService {
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	
	Post updatePost(PostDto postDto, Integer postId);
	
	void deletePost(Integer postId);
	
	List<Post> getAllPost();
	
	Post getPostById(Integer postId);
	
	List<PostDto> getPostByCategory(Integer categoryId);
	
	List<PostDto> getPostByUser(Integer userId);
	
	List<Post> serachPosts(String keyword);

	

}
