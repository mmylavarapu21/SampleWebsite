package com.engage3.hirerarchy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="PRODUCT")
public class Product {
	//id, UPC, name, price and category.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", UPC=" + UPC + ", name=" + name + ", category=" + category + ", price=" + price
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getUPC() {
		return UPC;
	}

	public void setUPC(long uPC) {
		UPC = uPC;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(name = "UPC", unique = true, nullable = false)
	private long UPC;
	
	@Size(min=2, max=50)
	@Column(name = "NAME", unique=true, nullable = false)
	private String name;
	
	@Size(min=2, max=50)
	@Column(name = "CATEGORY", nullable = false)
	private String category;
	
	@NotNull
	@Digits(integer=8, fraction=3)
	@Column(name = "PRICE", nullable = false)
	private float price;
}
