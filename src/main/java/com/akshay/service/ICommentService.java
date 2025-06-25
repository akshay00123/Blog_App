package com.akshay.service;

import com.akshay.dto.CommentDto;
import com.akshay.utils.ApiResponse;

public interface ICommentService {
    ApiResponse addComment(CommentDto comment, Integer userId, Integer postId);

    ApiResponse getAllCommentsOnPost(Integer postId);

    ApiResponse deleteComment(Integer commentId);
}
