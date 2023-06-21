package com.product.demo.ProductService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.demo.ProductRepository.ProductRepository;
import com.product.demo.dto.ProductPojo;
import com.product.demo.entity.ProductEntity;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public boolean addProduct(ProductPojo prodcutPojo) {
		var price = prodcutPojo.getProdPrice();
		System.out.println("Price--->" + price);
		double gst = price * 0.05;
		System.out.println("GST--->" + gst);
		double discount = 0;
		if (price >= 1000) {
			discount = price * 0.1;
		}

		System.out.println("Discount--->" + discount);
		double total = (price + gst - (discount));
		System.out.println("total--->" + total);

		prodcutPojo.setDiscount(discount);
		prodcutPojo.setGst(gst);
		prodcutPojo.setTotalPrice(total);

		ProductEntity entity = new ProductEntity();
		BeanUtils.copyProperties(prodcutPojo, entity);
		System.out.println("ProductEntity--->" + entity);
		if (price >= 0) {
			ProductEntity saveEntity = productRepository.save(entity);
			return saveEntity.getProdId() != null;
		} else {
			ProductEntity saveEntity = null;
			return saveEntity.getProdId() == null;
		}
	}
	

	@Override
	public List<ProductPojo> getAllProduct() {
		List<ProductEntity> findAll = productRepository.findAll();
		ArrayList<ProductPojo> list = new ArrayList<ProductPojo>();
		for (ProductEntity data : findAll) {
			ProductPojo productPojo = new ProductPojo();
			BeanUtils.copyProperties(data, productPojo);
			list.add(productPojo);
		}
		return list;
	}

	@Override
	public ProductPojo getProductById(int id) {

		ProductEntity productEntity = productRepository.findById(id).get();
		ProductPojo productPojo = new ProductPojo();
		BeanUtils.copyProperties(productEntity, productPojo);
		return productPojo;
	}

	@Override
	public String deleteProductById(int id) {
		productRepository.deleteById(id);
		return "Data deleted successfully";
	}

	@Override
	public Boolean editProduct(int id, ProductEntity productEntity) {
		ProductEntity productEntity1 = productRepository.findById(id).get();
		ProductPojo productPojo = new ProductPojo();
		BeanUtils.copyProperties(productEntity1, productPojo);
		var price = productPojo.getProdPrice();
		System.out.println("Price--->" + price);
		double gst = price * 0.05;
		System.out.println("GST--->" + gst);
		double discount = 0;
		if (price >= 1000) {
			discount = price * 0.1;
		}

		System.out.println("Discount--->" + discount);
		double total = (price + gst - (discount));
		System.out.println("total--->" + total);

		productPojo.setDiscount(discount);
		productPojo.setGst(gst);
		productPojo.setTotalPrice(total);

		BeanUtils.copyProperties(productPojo, productEntity);
		System.out.println("ProductEntity--->" + productEntity);
		if (price >= 0) {
			ProductEntity saveEntity = productRepository.save(productEntity);
			return saveEntity.getProdId() != null;
		} else {
			ProductEntity saveEntity = null;
			return saveEntity.getProdId() == null;
		}
	}

	

}
