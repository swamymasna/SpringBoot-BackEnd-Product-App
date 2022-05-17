package com.swamy.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swamy.bindings.Product;
import com.swamy.constants.AppConstants;
import com.swamy.entity.ProductEntity;
import com.swamy.exception.ProductResourceNotFoundException;
import com.swamy.properties.AppProperties;
import com.swamy.repository.ProductRepository;
import com.swamy.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private AppProperties appProperties;

	@Override
	public String saveProduct(Product product) {

		String message = null;

		ProductEntity productEntity = new ProductEntity();


		BeanUtils.copyProperties(product, productEntity);

		productEntity.setProdDiscount(productEntity.getProdCost() * 12.0/100);

		productEntity.setProdGst(productEntity.getProdCost() * 14.0/100);


		ProductEntity savedProduct = productRepository.save(productEntity);

		if (savedProduct.getProdId() != null) {
			//appProperties.getMessages().get("productSaved");
			//message = "Product Data '" + savedProduct.getProdId() + "' Saved Successfully";
			appProperties.getMessages().get(AppConstants.PRODUCT_SAVED);
		} else {
			message = appProperties.getMessages().get(AppConstants.PRODUCT_FAILED_TO_SAVE);
		}

		return message;
	}

	@Override
	public List<Product> getAllProducts() {

		List<Product> list = new ArrayList<>();

		List<ProductEntity> findAll = productRepository.findAll();

		for (ProductEntity productEntity : findAll) {
			Product product = new Product();
			BeanUtils.copyProperties(productEntity, product);
			list.add(product);
		}

		return list;
	}

	@Override
	public Product getOneProduct(Integer id) throws Exception {

		Product product = null;

		Optional<ProductEntity> findById = productRepository.findById(id);

		if (findById.isPresent()) {
			ProductEntity productEntity = findById.get();
			product = new Product();
			BeanUtils.copyProperties(productEntity, product);
		}
		else {
			throw new ProductResourceNotFoundException(appProperties.getMessages().get(AppConstants.EXCEPTION_MSG));
		}

		return product;
	}

	@Override
	public List<Product> deleteProduct(Integer id) throws Exception {

		Optional<ProductEntity> findById = productRepository.findById(id);

		if(findById.isPresent()) {
			productRepository.deleteById(id);
		}
		else {
			throw new ProductResourceNotFoundException(appProperties.getMessages().get(AppConstants.EXCEPTION_MSG));
		}


		return getAllProducts();
	}

	@Override
	public String updateProduct(Product product) {

		String message = null;

		ProductEntity productEntity = new ProductEntity();
		BeanUtils.copyProperties(product, productEntity);

		ProductEntity updatedProduct = productRepository.save(productEntity);

		if (updatedProduct.getProdId() != null) {
			message = appProperties.getMessages().get(AppConstants.UPDATED_PRODUCT_DATA);
		} else {
			message = appProperties.getMessages().get(AppConstants.FAILED_TO_UPDATE);
		}

		return message;
	}

	@Override
	public String updateProductById(Product product, Integer id) {

		String message = null;

		ProductEntity productEntity = new ProductEntity();
		BeanUtils.copyProperties(product, productEntity);

		ProductEntity updatedProduct = productRepository.save(productEntity);

		if (updatedProduct.getProdId() != null) {
			message = appProperties.getMessages().get(AppConstants.UPDATED_PRODUCT_DATA);
		} else {
			message = appProperties.getMessages().get(AppConstants.FAILED_TO_UPDATE);
		}

		return message;
	}

}
