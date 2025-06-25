package com.akshay.service;

import com.akshay.dto.CategoryDto;
import com.akshay.utils.ApiResponse;

public interface ICategoryService {
    ApiResponse getCategoryById(Integer id);

    ApiResponse getAllCategory();

    ApiResponse deleteCategoryById(Integer id);

    ApiResponse updateCategory(CategoryDto categoryDto);

    ApiResponse createCategory(CategoryDto categoryDto);
}
