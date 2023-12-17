package com.codewithrajeev.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "Post id", postId));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName(postDto.getImageName());
        
        Post updatedPost = this.postRepo.save(post);
		return this.modelMapper.map(updatedPost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "Post id", postId));
		this.postRepo.delete(post);
	}

	@Override
	public List<PostDto> getAllPost(Integer pageNumber, Integer pageSize) {
		
		Pageable p = PageRequest.of(pageNumber, pageSize);
		Page<Post> pagePost = this.postRepo.findAll(p);
		
		List<Post> posts =pagePost.getContent();
		List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post", "postId", postId));
		return this.modelMapper.map(post, PostDto.class);
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
