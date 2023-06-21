package com.product.demo.ProductRepository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.demo.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Serializable> {


}
