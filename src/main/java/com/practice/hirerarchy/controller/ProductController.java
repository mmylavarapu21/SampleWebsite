package com.engage3.hirerarchy.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.engage3.hirerarchy.service.CategoryServiceImpl;
import com.engage3.hirerarchy.service.ProductServiceImpl;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	ProductServiceImpl productService;
	
	@RequestMapping(value = {"/view"}, method = RequestMethod.GET)
	public List<?> viewChildHirerarchy(@RequestBody String category) {
		return productService.showProducts(category);
	}
	
	@RequestMapping(value = {"/add"}, method = RequestMethod.POST)
	public void addData(@RequestBody String data) {
		productService.createProduct(data);
	}
	
	@RequestMapping(value = {"/edit"}, method = RequestMethod.PUT)
	public void editData(@RequestBody String data) {
		productService.updateProduct(data);
	}
	
	@RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
	public void deleteData(@RequestBody String id) {
		productService.removeProduct(id);
	}
}
