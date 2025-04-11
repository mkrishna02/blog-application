package com.learn.blog.services;

import java.util.List;

import com.learn.blog.payloads.CategoryDto;
// This interface is created for loose coupling so that we can change anything in the code 
public interface CategoryService {
	
	//create
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	//delete
	public void deleteCategory(Integer categoryId);
	
	//get single category
	public CategoryDto getCategory(Integer categoryId);
	
	//get all
	public List<CategoryDto> getCategories();

}
