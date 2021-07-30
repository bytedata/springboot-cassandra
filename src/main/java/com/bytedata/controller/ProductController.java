package com.bytedata.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bytedata.model.Product;
import com.bytedata.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository repository;

	@PostConstruct
	public void saveProduct() {
		List<Product> products = new ArrayList<>();
		products.add(new Product(101, "Computer", 1, 200000.00));
		products.add(new Product(102, "Headset", 20, 999.00));
		products.add(new Product(103, "Mobile", 15, 67000.00));
		products.add(new Product(104, "pendrive", 4, 3000.00));
		repository.saveAll(products);
	}

	@GetMapping("/getAllProducts")
	public List<Product> getProducts() {
		return repository.findAll();
	}

	@GetMapping("/getProductFilterByPrice/{price}")
	public List<Product> getProductFilterByPrice(@PathVariable double price) {
		return repository.findByPriceGreaterThan(price);
	}

}
