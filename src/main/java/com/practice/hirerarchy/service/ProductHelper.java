package com.engage3.hirerarchy.service;

import org.springframework.stereotype.Service;

@Service
public class ProductHelper {
	
	public ProductHelper(){
		
	}
	public ProductHelper(int id, long upc,String name, String category,float price){
		this.id = id;
		this.upc = upc; 
		this.name = name;
		this.category = category;
		this.price = price;
	}
	
	private int id;
	private long upc;
	private String name;
	private String category;
	private float price;
}
