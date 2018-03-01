package com.engage3.hirerarchy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="CATEGORY")
public class Category {
	//id, name, parentcategory, childcategories
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(String parentCategory) {
		this.parentCategory = parentCategory;
	}

	public String getChildCategory() {
		return childCategory;
	}

	public void setChildCategory(String childCategory) {
		this.childCategory = childCategory;
	}

	@Size(min=2, max=50)
	@Column(name = "NAME", unique=true, nullable = false)
	private String name;
	
	@Size(min=2, max=50)
	@Column(name = "PARENTCATEGORY")
	private String parentCategory;
	
	@Size(min=2, max=50)
	@Column(name = "CHILDCATEGORY")
	private String childCategory;

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", parentCategory=" + parentCategory + ", childCategory="
				+ childCategory + "]";
	}
}
