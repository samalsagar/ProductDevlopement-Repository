package com.product.demo.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "productDetails_SAGAR_PRITI")
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Prod_Id")
	private Integer prodId;

	@Column(name = "Prod_Name")
	private String prodName;

	@Column(name = "Prod_Code")
	private String prodCode;

	@Column(name = "Prod_Price")
	private double prodPrice;

	@Column(name = "Prod_Discount")
	private double discount;

	@Column(name = "Prod_gst")
	private double gst;

	@Column(name = "Total_Price")
	private double totalPrice;

}
