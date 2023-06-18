package com.product.demo.dto;

import lombok.Data;

@Data
public class ProductPojo {
	
	private int prodId;

	private String prodName;

	private String prodCode;

	private double prodPrice;

	private double discount;

	private double gst;

	private double totalPrice;
}
