package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.beans.Category;
import com.demo.dao.CategoryDao;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryDao.findAll(pageable);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public Category createCategory(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category updatedCategory) {
        Category category = categoryDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        category.setName(updatedCategory.getName());
        return categoryDao.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
    	categoryDao.deleteById(id);
    }
}

