package com.niit.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CategoryInfo() {
	}

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int c_id;
	
	@Column
	private String category_name;
	@OneToMany(mappedBy="category_fk",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<ProductInfo> product;
	public CategoryInfo(int c_id, String category_name) {
		super();
		this.c_id = c_id;
		this.category_name = category_name;
		
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	
	public List<ProductInfo> getProduct() {
		return product;
	}

	public void setProduct(List<ProductInfo> product) {
		this.product = product;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

}
