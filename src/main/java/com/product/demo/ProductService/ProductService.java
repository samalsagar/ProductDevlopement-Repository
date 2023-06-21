package com.product.demo.ProductService;

import java.util.List;

import com.product.demo.dto.ProductPojo;
import com.product.demo.entity.ProductEntity;


public interface ProductService {
	
	public boolean addProduct(ProductPojo prodcutPojo);
	
	public List<ProductPojo> getAllProduct();
	
	public ProductPojo getProductById(int id);
	
	public String deleteProductById(int id);
	
	public Boolean editProduct(int id, ProductEntity productEntity);
}
