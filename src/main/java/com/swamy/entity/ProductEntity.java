package com.swamy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCT_TABLE")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID")
	private Integer prodId;

	@Column(name = "PRODUCT_CODE")
	private String prodCode;

	@Column(name = "PRODUCT_COST")
	private Double prodCost;

	@Column(name = "PRODUCT_DISCOUNT")
	private Double prodDiscount;

	@Column(name = "PRODUCT_GST")
	private Double prodGst;

}
