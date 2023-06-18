package com.product.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity {
	@Id
	@GeneratedValue
	@Column(name = "Prod_Id")
	private int prodId;

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

	public ProductEntity(int prodId, String prodName, String prodCode, double prodPrice, double discount, double gst,
			double totalPrice) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodCode = prodCode;
		this.prodPrice = prodPrice;
		this.discount = discount;
		this.gst = gst;
		this.totalPrice = totalPrice;
	}

	public ProductEntity() {
		super();
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public double getDiscount() {
		if(prodPrice>=1000) {
			discount = 0.10;
			return discount;
		}
		return discount;
	}
	
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	
	public double getGst() {
		gst = 0.05;
		return gst;
	}
	
	public void setGst(double gst) {
		this.gst = gst;
	}


	public double getTotalPrice() {
		discount = prodPrice*discount;
		gst = prodPrice*gst;
		totalPrice = prodPrice-discount+gst;
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "ProductEntity [prodId=" + prodId + ", prodName=" + prodName + ", prodCode=" + prodCode + ", prodPrice="
				+ prodPrice + ", discount=" + discount + ", gst=" + gst + ", totalPrice=" + totalPrice + "]";
	}

}
