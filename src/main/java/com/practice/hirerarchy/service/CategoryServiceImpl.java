package com.engage3.hirerarchy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engage3.hirerarchy.dao.CategoryDaoImpl;
import com.engage3.hirerarchy.dao.ProductDaoImpl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryDaoImpl categoryDaoImpl;
	
	public String showParentCategory(String category){
			return categoryDaoImpl.showParentCategory(category);
	}
	
	public List<?> showChildCategory(String category){
		return categoryDaoImpl.showChildCategory(category);
}
	
	public void createCategory(String data){
		JsonObject jsonData = new Gson().fromJson(data, JsonObject.class);
		String parentCategory= jsonData.get("parentCategory").getAsString();
	    String childCategory = jsonData.get("childCategory").getAsString();
	    String category = jsonData.get("category").getAsString();
		categoryDaoImpl.createCategory(parentCategory, childCategory, category);
	}
	
	public void removeCategory(String category){
		categoryDaoImpl.removeCategory(category);
	}
	
	public void updateCategory(String data){
		JsonObject jsonData = new Gson().fromJson(data, JsonObject.class);
		String category = jsonData.get("category").getAsString();
		String changeCategory = jsonData.get("changeCategory").getAsString();
		String change = jsonData.get("change").getAsString();
		categoryDaoImpl.updateCategory(category, changeCategory, change);
	}
}
