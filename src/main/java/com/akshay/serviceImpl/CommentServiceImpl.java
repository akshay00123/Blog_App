package com.akshay.serviceImpl;

import com.akshay.utils.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.akshay.dto.CommentDto;
import com.akshay.exceptions.CustomException;
import com.akshay.model.Comment;
import com.akshay.model.Post;
import com.akshay.model.User;
import com.akshay.repository.ICommentRepository;
import com.akshay.repository.IPostRepository;
import com.akshay.repository.IUserRepository;
import com.akshay.service.ICommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private ICommentRepository commentRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ApiResponse addComment(CommentDto commentDto, Integer userId, Integer postId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException("User not found by id " + userId, HttpStatus.NOT_FOUND, false));
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new CustomException("Post not found by id " + postId, HttpStatus.NOT_FOUND, false));
        Comment comment = modelMapper.map(commentDto, Comment.class);
        comment.setUser(user);
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        return new ApiResponse("success", 200, true, modelMapper.map(savedComment, CommentDto.class));
    }

    @Override
    public ApiResponse getAllCommentsOnPost(Integer postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new CustomException("Post not found by id " + postId, HttpStatus.NOT_FOUND, false));
        ApiResponse apiResponse = new ApiResponse("success", 200, true, null);
        List<CommentDto> commentDtoList = post.getCommentsList()
                .stream()
                .map(comment -> modelMapper.map(comment, CommentDto.class))
                .toList();
        apiResponse.setData(commentDtoList);
        return apiResponse;
    }

    @Override
    public ApiResponse deleteComment(Integer commentId) {
        Comment comment = commentRepository
                .findById(commentId)
                .orElseThrow(
                        () -> new CustomException("Comment not found by id " + commentId, HttpStatus.NOT_FOUND, false));
        commentRepository.delete(comment);
        return new ApiResponse("success", 200, true, modelMapper.map(comment, CommentDto.class));
    }

}
