package com.engage3.hirerarchy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.engage3.hirerarchy.dao.ProductDaoImpl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDaoImpl productDaoImpl;

	public List<ProductHelper> showProducts(String category) {
		return productDaoImpl.showProducts(category);
	}

	public void createProduct(String data) {
		JsonObject jsonData = new Gson().fromJson(data, JsonObject.class);
		long upc = jsonData.get("upc").getAsLong();
		String name =  jsonData.get("name").getAsString();
		String category =  jsonData.get("category").getAsString();
		float price = jsonData.get("price").getAsFloat();
		productDaoImpl.createProduct(upc, name, category, price);
	}

	public void removeProduct(String data) {
		int iD = Integer.parseInt(data);
		productDaoImpl.removeProduct(iD);
	}

	public void updateProduct(String data) {
		JsonObject jsonData = new Gson().fromJson(data, JsonObject.class);
		int id =  jsonData.get("id").getAsInt();
		String change =  jsonData.get("change").getAsString();
		String changeValue = jsonData.get("changeValue").getAsString();
		productDaoImpl.updateProduct(id, changeValue, change);
	}
}
