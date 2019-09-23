package com.caridadja.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caridadja.productsandcategories.models.Category;
import com.caridadja.productsandcategories.models.Product;
import com.caridadja.productsandcategories.repositories.CategoryRepository;
import com.caridadja.productsandcategories.repositories.ProductRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductService productService;
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
	public List<Category> getAll() {
		return (List<Category>) categoryRepository.findAll();
	}
	public Category getCategory(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		if(category.isPresent()){
			Category getCategory = category.get();
			return getCategory;
		}
		else {
			return null;
		}
	}
	public void update(Category category) {
		categoryRepository.save(category);
	}
	public List<Category> getSpecific(Long id) {
		List<Category> categories = this.getAll();
		List<Category> categoriesUsed = productService.findProduct(id).getCategories();
		categories.removeAll(categoriesUsed);
		return categories;
	}
}
