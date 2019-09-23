package com.caridadja.productsandcategories.repositories;

import org.springframework.data.repository.CrudRepository;

import com.caridadja.productsandcategories.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
