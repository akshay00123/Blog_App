package com.akshay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshay.model.Comment;

public interface ICommentRepository extends JpaRepository<Comment, Integer> {

}
