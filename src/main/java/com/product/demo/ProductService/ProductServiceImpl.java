package com.product.demo.ProductService;

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
		double gst=price * 0.05;
		System.out.println("GST--->" + gst);
		double discount = 0;
		if(price>=1000) {
			discount = price*0.1;
		} 
		
		System.out.println("Discount--->" + discount);
		double total = (price + gst-(discount));
		 System.out.println("total--->" + total);
		 
		 
		prodcutPojo.setDiscount(discount);
		prodcutPojo.setGst(gst);
		prodcutPojo.setTotalPrice(total);
		
		ProductEntity entity = new ProductEntity();
		BeanUtils.copyProperties(prodcutPojo, entity);
		System.out.println("ProductEntity--->" + entity);
		 ProductEntity saveEntity = productRepository.save(entity);
		 return saveEntity.getProdId()!=null;
	}

}
