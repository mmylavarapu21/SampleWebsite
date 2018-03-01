package com.engage3.hirerarchy.service;

import java.util.List;

public interface CategoryService {
	
	String showParentCategory(String category);
	
	List<?> showChildCategory(String category);
	
	void createCategory(String data);
	
	void removeCategory(String category);
	
	void updateCategory(String data);
}
