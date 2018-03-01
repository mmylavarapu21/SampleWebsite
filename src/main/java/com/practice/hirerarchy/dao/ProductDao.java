package com.engage3.hirerarchy.dao;


import java.util.List;

import com.engage3.hirerarchy.service.ProductHelper;

public interface ProductDao {

	List<ProductHelper> showProducts(String category);
	
	void createProduct(long upc,String name, String category,float price);
	
	void removeProduct(int iD);
	
	void updateProduct(int id,String change,String changeValue);
}
