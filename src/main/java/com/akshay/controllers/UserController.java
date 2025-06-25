package com.akshay.controllers;

import com.akshay.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.constants.AppConstants;
import com.akshay.dto.UserDto;
import com.akshay.service.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> createUser(@Valid @RequestBody UserDto user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable Integer id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<ApiResponse> getAllUsers(
            @RequestParam(required = false, defaultValue = AppConstants.PAGE_NUMBER) Integer pageNo,
            @RequestParam(required = false, defaultValue = AppConstants.PAGE_SIZE) Integer pageSize) {
        return new ResponseEntity<>(userService.getAllUsers(pageNo, pageSize), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteUserById(@PathVariable Integer id) {
        return new ResponseEntity<>(userService.deleteUserById(id), HttpStatus.OK);
    }
}
