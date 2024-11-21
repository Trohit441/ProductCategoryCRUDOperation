package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.beans.Category;

public interface CategoryDao extends JpaRepository<Category, Long> {
}

