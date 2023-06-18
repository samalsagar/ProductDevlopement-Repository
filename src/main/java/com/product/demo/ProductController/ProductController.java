package com.product.demo.ProductController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.demo.ProductService.ProductServiceImpl;
import com.product.demo.dto.ProductPojo;

@Controller
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
	public String saveProduct(@ModelAttribute ProductPojo productPojo) {
		System.out.println(" ---->" + productPojo);
		boolean addProduct = productServiceImpl.addProduct(productPojo);
		if(addProduct) {
			System.out.println("Data Saved successfully");
		} else {
			System.out.println("Data Not Saved");
		}
		return "null";
	}
	
	
	
}
