package com.akshay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshay.model.Category;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

}
