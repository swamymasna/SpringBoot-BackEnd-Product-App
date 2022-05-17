package com.swamy.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swamy.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Serializable> {

}

