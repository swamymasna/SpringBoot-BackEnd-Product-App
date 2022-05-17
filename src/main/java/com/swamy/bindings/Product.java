package com.swamy.bindings;

import lombok.Data;

@Data
public class Product {

	private Integer prodId;

	private String prodCode;
	
	private Double prodCost;
	
	private Double prodDiscount;
	
	private Double prodGst;
}
