package com.akshay.service;

import com.akshay.dto.PostDto;
import com.akshay.utils.ApiResponse;
import com.akshay.utils.PostsResponse;

public interface IPostService {

    ApiResponse createPost(PostDto postDto, Integer userId, Integer categoryId, String imageUrl);

    ApiResponse getPostsById(Integer postId);

    ApiResponse getAllPostsByUser(Integer userId);

    ApiResponse getAllPostsByCategory(Integer categoryId);

    PostsResponse getAllPosts(Integer pageNo, Integer pageSize, String sortBy, Boolean asc);

    ApiResponse deletePostById(Integer postId);

    ApiResponse updatePost(PostDto postDto);

    ApiResponse searchPostsByTitle(String title);

}
