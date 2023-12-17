package com.codewithrajeev.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithrajeev.blog.entities.Post;
import com.codewithrajeev.blog.entities.User;
import com.codewithrajeev.blog.entities.Category;
import com.codewithrajeev.blog.exceptions.ResourceNotFoundException;
import com.codewithrajeev.blog.payloads.PostDto;
import com.codewithrajeev.blog.repositories.CategoryRepo;
import com.codewithrajeev.blog.repositories.PostRepo;
import com.codewithrajeev.blog.repositories.UserRepo;
import com.codewithrajeev.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper; 

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","user id",userId));
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category","category id",categoryId));
		
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		Post newPost = this.postRepo.save(post);
	    
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public Post updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		   Category cat =  this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category","category id", categoryId));
		   List<Post> posts = this.postRepo.findByCategory(cat);
		   List<PostDto> postdto = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	  	
		
		return postdto;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		   User user  =  this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user","user id", userId));
		   List<Post> posts = this.postRepo.findByUser(user);
		   List<PostDto> postdto = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	  	
		
		return postdto;
	}

	@Override
	public List<Post> serachPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
