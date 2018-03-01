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
@RequestMapping(value = "/category")
public class CategoryController {

	@Autowired
	CategoryServiceImpl categoryService;
	
	@RequestMapping(value = {"/view/child"}, method = RequestMethod.GET)
	public List<?> viewChildHirerarchy(@RequestBody String category) {
		return categoryService.showChildCategory(category);
	}
	
	@RequestMapping(value = {"/view/parent"}, method = RequestMethod.GET)
	public String viewParentCategory(@RequestBody String category) {
		return categoryService.showParentCategory(category);
	}
	
	@RequestMapping(value = {"/add"}, method = RequestMethod.POST)
	public void addData(@RequestBody String data) {
		categoryService.createCategory(data);
	}
	
	@RequestMapping(value = {"/edit"}, method = RequestMethod.PUT)
	public void editData(@RequestBody String data) {
		categoryService.updateCategory(data);
	}
	
	@RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
	public void deleteData(@RequestBody String category) {
		categoryService.removeCategory(category);
	}
}
