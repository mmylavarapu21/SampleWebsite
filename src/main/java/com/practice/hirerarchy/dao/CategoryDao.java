package com.engage3.hirerarchy.dao;

import java.util.List;

public interface CategoryDao {

	String showParentCategory(String category);
	
	List<?> showChildCategory(String category);
	
	void createCategory(String parentCategory,String childCategory,String category);
	
	void removeCategory(String category);
	
	void updateCategory(String category, String changeCategory,String change);
}
