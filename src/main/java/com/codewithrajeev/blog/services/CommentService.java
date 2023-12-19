package com.codewithrajeev.blog.services;

import com.codewithrajeev.blog.payloads.CommentDto;

public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto, Integer postId);
	void deleteComment(Integer commentId);

}
