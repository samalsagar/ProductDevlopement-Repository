package com.product.demo.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.demo.ProductRepository.ProductRepository;
import com.product.demo.entity.ProductEntity;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Override
	public ProductEntity addProduct(ProductEntity productEntity) {
		return productRepository.save(productEntity);
	}

}
