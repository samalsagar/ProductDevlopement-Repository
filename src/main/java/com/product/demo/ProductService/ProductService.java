package com.product.demo.ProductService;

import java.util.List;

import com.product.demo.entity.ProductEntity;


public interface ProductService {
	
	public ProductEntity addProduct(ProductEntity productEntity);
	public List<ProductEntity> viewAllProduct();
}
