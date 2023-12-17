package com.codewithrajeev.blog.services;

import java.util.List;

import com.codewithrajeev.blog.entities.Post;
import com.codewithrajeev.blog.payloads.PostDto;
import com.codewithrajeev.blog.payloads.PostResponse;

public interface PostService {
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	void deletePost(Integer postId);
	
	PostResponse getAllPost(Integer PageNumber, Integer PageSize);
	
	PostDto getPostById(Integer postId);
	
	List<PostDto> getPostByCategory(Integer categoryId);
	
	List<PostDto> getPostByUser(Integer userId);
	
	List<Post> serachPosts(String keyword);

	

}
