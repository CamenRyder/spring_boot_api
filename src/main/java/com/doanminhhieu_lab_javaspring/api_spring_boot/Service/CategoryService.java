package com.doanminhhieu_lab_javaspring.api_spring_boot.Service;


import com.doanminhhieu_lab_javaspring.api_spring_boot.Model.Category;
import com.doanminhhieu_lab_javaspring.api_spring_boot.Repositories.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CategoryService  {
    private final ICategoryRepository categoryRepository;


    public List<Category> getAllCategories() {

        return categoryRepository.findAll() ;
    }


    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void updateCategory(Category category) {
        Category existingCategory = categoryRepository.findById(category.getId()).orElse(null);
        Objects.requireNonNull(existingCategory).setName(category.getName());
        categoryRepository.save(existingCategory);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
