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
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryService categoryService;
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	public List<Product> getAll(){
		return (List<Product>) productRepository.findAll();
	}
	public Product findProduct(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			Product getProduct = product.get();
			return getProduct;
		}
		else {
			return null;
		}
	}
	public void update(Product product) {
		productRepository.save(product);
	}
	public List<Product> getSpecific(Long id) {
		List<Product> products = this.getAll();
		List<Product> productsUsed = categoryService.getCategory(id).getProducts();
		products.removeAll(productsUsed);
		return products;
	}
}
