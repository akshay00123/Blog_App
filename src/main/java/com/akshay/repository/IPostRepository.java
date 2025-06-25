package com.akshay.repository;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshay.model.Post;
import com.akshay.model.User;

public interface IPostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);

    List<Category> findByCategory(Category category);

    List<Post> findByTitleContaining(String title);
}
