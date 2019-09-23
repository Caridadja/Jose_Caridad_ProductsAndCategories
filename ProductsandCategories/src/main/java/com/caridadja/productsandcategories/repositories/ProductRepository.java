package com.caridadja.productsandcategories.repositories;

import org.springframework.data.repository.CrudRepository;

import com.caridadja.productsandcategories.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
