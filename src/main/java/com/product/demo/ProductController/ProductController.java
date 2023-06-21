package com.product.demo.ProductController;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.demo.ProductService.ProductServiceImpl;
import com.product.demo.dto.ProductPojo;
import com.product.demo.entity.ProductEntity;

@RestController
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@GetMapping("/loadFrom")
	public String saveData(Model model) {
		System.out.println("Load Frm");
		ProductPojo object = new ProductPojo();
		model.addAttribute("productPojo", object);
		return "home";
	}

	@PostMapping("/saveProduct")
	public String saveProduct(@RequestBody ProductPojo productPojo) {
		System.out.println(" ---->" + productPojo);
		boolean addProduct = productServiceImpl.addProduct(productPojo);
		if (addProduct) {
			System.out.println("Data Saved successfully");
		} else {
			System.out.println("Data Not Saved");
		}
		return "Record saved successfully";
	}
	
	@GetMapping("/getAllData")
	public List<ProductPojo> getAllData(Model model) {//Break point is there 
		
		List<ProductPojo> allProduct = productServiceImpl.getAllProduct();
		System.out.println("All Product-->" + allProduct);

		
		return allProduct;//AND here another break point
	}
	
	@GetMapping("/getone/{id}")
	public ProductPojo getProductById(@PathVariable("id") int id,Model Model)
	{
		return productServiceImpl.getProductById(id);
	}
	
	@PutMapping("/editproduct/{id}")
	public String editProduct(@PathVariable("id")int id,@RequestBody ProductEntity productEntity)
	{
		productServiceImpl.editProduct(id, productEntity);
		return "Record Updated sucessfully";
	}

	@DeleteMapping("/deleteprod/{id}")
	public String deleteProductById(@PathVariable("id") int id)
	{
		
		return productServiceImpl.deleteProductById(id);
	}
}
