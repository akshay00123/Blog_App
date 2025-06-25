package com.akshay.service;

import com.akshay.dto.UserDto;
import com.akshay.utils.ApiResponse;

public interface IUserService {

    ApiResponse getUserById(Integer id);

    ApiResponse getAllUsers(Integer pageNo, Integer maxPage);

    ApiResponse deleteUserById(Integer id);

    ApiResponse updateUser(UserDto user);

    ApiResponse createUser(UserDto user);
}
