package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductCRUD;

@RestController
public class ProductController {

	@Autowired
	ProductCRUD crud;
	
	@GetMapping(value="/hello")
	public String hellWorld() {
		
		return "Hello Coding World";
	}
	
	
	@PostMapping(value="/product")
	public Product saveProduct(@RequestBody Product product) {
		Product save = crud.save(product);
		return save;
	}
	
	@GetMapping(value="/products")
	public List<Product> getProducts() {
		
		Iterable<Product> findAll = crud.findAll();
		List<Product> productList=new ArrayList<>();
		findAll.forEach(ele->{
			productList.add(ele);
		});
		return productList;
	}

}
