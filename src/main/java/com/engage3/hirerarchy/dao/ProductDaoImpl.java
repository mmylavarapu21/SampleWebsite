package com.engage3.hirerarchy.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.engage3.hirerarchy.model.Category;
import com.engage3.hirerarchy.model.Product;
import com.engage3.hirerarchy.service.ProductHelper;

@Service
@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao {

@Autowired
ProductHelper productHelper;
	
public List<ProductHelper> showProducts(String category){
	Query query = getSession().createSQLQuery("select * from PRODUCT where category :category");
	query.setString("category", category);
	return (List<ProductHelper>) query.list();
}
	
public void createProduct(long upc,String name, String category,float price){
	Query query = getSession().createSQLQuery("insert into PRODUCT where category = :category,upc = :upc,price =:price,name =:name");
	query.setString(name, name);
	query.setString(category, category);
	query.setLong("upc", upc);
	query.setFloat("price", price);
	query.executeUpdate();
}
	
	public void removeProduct(int iD){
		Query query = getSession().createSQLQuery("delete from PRODUCT where id = :id");
		query.setInteger(iD, iD);
		query.executeUpdate();
	}
	
	public void updateProduct(int id,String change,String changeType){
		Query query = getSession().createSQLQuery("update PRODUCT set changeType = change where id = :id");
		query.setString(changeType, change);
		query.setInteger(id, id);
		query.executeUpdate();
	}
}
