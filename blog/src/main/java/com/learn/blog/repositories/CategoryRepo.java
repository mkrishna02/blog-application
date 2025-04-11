package com.learn.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
