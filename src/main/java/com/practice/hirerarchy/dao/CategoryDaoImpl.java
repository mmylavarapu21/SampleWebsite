package com.engage3.hirerarchy.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.engage3.hirerarchy.model.Category;

@Service
@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDao<Integer, Category> implements CategoryDao {

	public String showParentCategory(String category){
		Query query = getSession().createSQLQuery("select parentCategory from CATEGORY where category = :category");
		query.setString("category", category);
		return query.getQueryString();
	}
	
	public List<?> showChildCategory(String category){
		Query query = getSession().createSQLQuery("select childCategory from CATEGORY where category = :category");
		query.setString("category", category);
		return query.list();
	}

	public void createCategory(String parentCategory,String childCategory,String category){
		Query query = getSession().createSQLQuery("insert into CATEGORY where category = :category, childCategory = :childCategory,parentCategory = :parentCategory");
		query.setString("category", category);
		query.setString("childCategory", childCategory);
		query.setString("parentCategory", parentCategory);
		query.executeUpdate();
	}
	
	public void removeCategory(String category){
		Query query = getSession().createSQLQuery("delete from CATEGORY where category = :category");
		query.setString("category", category);
		query.executeUpdate();
	}
	
	//changeCategory = parentCategory/childCategory
	public void updateCategory(String category, String changeCategory,String change){
		Query query = getSession().createSQLQuery("update CATEGORY set changeCategory = change where category = :category");
		query.setString(changeCategory, change);
		query.executeUpdate();
	}
}
