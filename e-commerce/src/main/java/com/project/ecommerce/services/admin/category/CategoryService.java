package com.project.ecommerce.services.admin.category;

import com.project.ecommerce.dto.CategoryDto;
import com.project.ecommerce.entities.Category;

import java.util.List;

public interface CategoryService {

    Category createcategory(CategoryDto categoryDto);

    List<Category> getAllCategories();
}
