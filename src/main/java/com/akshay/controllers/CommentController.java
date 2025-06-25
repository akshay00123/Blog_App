package com.akshay.controllers;

import com.akshay.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.dto.CommentDto;
import com.akshay.service.ICommentService;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @PostMapping("/user/{userId}/post/{postId}/save")
    public ResponseEntity<ApiResponse> addComment(@RequestBody CommentDto commentDto, @PathVariable Integer userId,
                                                  @PathVariable Integer postId) {
        ApiResponse savedComment = commentService.addComment(commentDto, userId, postId);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

    @GetMapping("/comments/post/{postId}")
    public ResponseEntity<ApiResponse> getAllCommentsOnPost(@PathVariable Integer postId) {
        ApiResponse commentsList = commentService.getAllCommentsOnPost(postId);
        return new ResponseEntity<>(commentsList, HttpStatus.CREATED);
    }

}