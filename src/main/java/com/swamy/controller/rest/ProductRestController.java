package com.swamy.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swamy.bindings.Product;
import com.swamy.service.IProductService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/products")
public class ProductRestController {

	@Autowired
	private IProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<String>saveProduct(@RequestBody Product product){
		return new ResponseEntity<String>(productService.saveProduct(product), HttpStatus.CREATED);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Product>>listProducts(){
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	}
	
	@GetMapping("/edit/{id}")
	public ResponseEntity<Product>editProduct(@PathVariable Integer id) throws Exception{
		return new ResponseEntity<>(productService.getOneProduct(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<Product>>deleteProduct(@PathVariable Integer id) throws Exception{
		return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<String>updateProduct(@RequestBody Product product){
		return new ResponseEntity<String>(productService.updateProduct(product), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String>updateProductById(@PathVariable Integer id , @RequestBody Product product){
		return new ResponseEntity<String>(productService.updateProductById(product, id), HttpStatus.OK);
	}
	
}

