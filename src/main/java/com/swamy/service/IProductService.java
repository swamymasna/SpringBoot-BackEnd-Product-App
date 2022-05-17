package com.swamy.service;

import java.util.List;

import com.swamy.bindings.Product;

public interface IProductService {

	public String saveProduct(Product product);
	
	public List<Product> getAllProducts();
	
	public Product getOneProduct(Integer id) throws Exception;
	
	public List<Product>deleteProduct(Integer id) throws Exception;

	public String updateProduct(Product product);

	public String updateProductById(Product product , Integer id);
}

