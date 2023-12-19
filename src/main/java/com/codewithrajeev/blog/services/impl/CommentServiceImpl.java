package com.codewithrajeev.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithrajeev.blog.entities.Comment;
import com.codewithrajeev.blog.entities.Post;
import com.codewithrajeev.blog.exceptions.ResourceNotFoundException;
import com.codewithrajeev.blog.payloads.CommentDto;
import com.codewithrajeev.blog.repositories.CommentRepo;
import com.codewithrajeev.blog.repositories.PostRepo;
import com.codewithrajeev.blog.services.CommentService;


@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(()->new ResourceNotFoundException("Post", "Post id", postId));
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		
		Comment savedComment = this.commentRepo.save(comment);
		
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment com = this.commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "Comment id", commentId));
		this.commentRepo.delete(com);
	}

}
