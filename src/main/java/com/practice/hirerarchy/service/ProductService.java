package com.engage3.hirerarchy.service;

import java.util.List;

public interface ProductService {
	
	List<ProductHelper> showProducts(String category);
	
	void createProduct(String data);
	
	void removeProduct(String data);
	
	void updateProduct(String data);
}
