package com.learn.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.blog.payloads.ApiResponse;
import com.learn.blog.payloads.CategoryDto;
import com.learn.blog.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService catService;
	// create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto catDto){
		CategoryDto createCat =  this.catService.createCategory(catDto);
		return new ResponseEntity<CategoryDto>(createCat, HttpStatus.CREATED);
	}
	// update
	@PutMapping("/{catId}")
	private ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto catDto, @PathVariable Integer catId){
		CategoryDto updatedCat = this.catService.updateCategory(catDto, catId);
		return new ResponseEntity<CategoryDto>(updatedCat, HttpStatus.OK);
	}
	// delete
	@DeleteMapping("/{catId}")
	private ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){
		this.catService.deleteCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category is deleted successfully.",true), HttpStatus.OK);
	}
	// get
	@GetMapping("/{catId}")
	private ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId){
		CategoryDto getCat = this.catService.getCategory(catId);
		return new ResponseEntity<CategoryDto>(getCat, HttpStatus.FOUND);
		
	}
	// get all categories
	@GetMapping("/")
	private ResponseEntity<List<CategoryDto>> getAllCategories() {
		List<CategoryDto> getAllCats = this.catService.getCategories();
		return ResponseEntity.ok(getAllCats);
	}
}
