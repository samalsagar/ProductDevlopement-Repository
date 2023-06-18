package com.product.demo.ProductService;

import java.util.List;

import com.product.demo.dto.ProductPojo;


public interface ProductService {
	
	public boolean addProduct(ProductPojo prodcutPojo);
	
	public List<ProductPojo> getAllProducts();
}
