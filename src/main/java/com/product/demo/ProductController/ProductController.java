package com.product.demo.ProductController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.demo.ProductService.ProductServiceImpl;
import com.product.demo.entity.ProductEntity;

@RestController
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@PostMapping("/addproducts")
	public ProductEntity addProduct(@RequestBody ProductEntity productEntity) {
		return productServiceImpl.addProduct(productEntity);
	}
}
