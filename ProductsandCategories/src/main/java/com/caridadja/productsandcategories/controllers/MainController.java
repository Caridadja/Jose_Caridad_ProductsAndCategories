package com.caridadja.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.caridadja.productsandcategories.models.Category;
import com.caridadja.productsandcategories.models.Product;
import com.caridadja.productsandcategories.services.CategoryService;
import com.caridadja.productsandcategories.services.ProductService;

@Controller
public class MainController {
	
	private final CategoryService categoryService;
	private final ProductService productService;
	
	public MainController(CategoryService categoryService, ProductService productService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	@PostMapping("/categories/new")
	public String createCategory(@ModelAttribute("category") Category category) {
		categoryService.addCategory(category);
		return "redirect:/categories/new";
	}
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	@PostMapping("/products/new")
	public String createProduct(@ModelAttribute("product") Product product) {
		productService.addProduct(product);
		return "redirect:/products/new";
	}
	@RequestMapping("products/{id}")
	public String showProduct(Model model, @PathVariable("id") Long id) {
		Product product = productService.findProduct(id);
		model.addAttribute("product", product);
		model.addAttribute("categories", categoryService.getSpecific(id));
		return "showProduct.jsp";
	}
	@PostMapping("/products/{id}")
	public String addCategory(@PathVariable("id") Long id, @RequestParam("category") Long categoryId) {
		Product product = productService.findProduct(id);
		Category category = categoryService.getCategory(categoryId);
		List<Category> categories = product.getCategories();
		categories.add(category);
		productService.update(product);
		return "redirect:/products/{id}";
	}
	@RequestMapping("/categories/{id}")
	public String showCategory(Model model, @PathVariable("id") Long id) {
		Category category = categoryService.getCategory(id);
		model.addAttribute("category", category);
		model.addAttribute("products", productService.getSpecific(id));
		return "showCategory.jsp";
	}
	@PostMapping("/categories/{id}")
	public String addProduct(@PathVariable("id") Long id, @RequestParam("product") Long productId) {
	Category category = categoryService.getCategory(id);
	Product product = productService.findProduct(productId);
	List<Product> products = category.getProducts();
	products.add(product);
	categoryService.update(category);
	return "redirect:/categories/{id}";
	}
}
