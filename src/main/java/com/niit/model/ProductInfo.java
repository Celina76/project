package com.niit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // for crating table in database
@Table(name = "product") // mention name for the table
public class ProductInfo implements Serializable // creating the class for
													// product details
													// implementing serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductInfo() {
	}// constructor is created for pojo class

	public ProductInfo(int id, String category_name, String product_name, int quantity, String description,
			MultipartFile image, int price, String supplier_name) {
		super();
		this.id = id;
		this.category_name = category_name;
		this.product_name = product_name;
		this.quantity = quantity;
		this.description = description;
		this.supplier_name = supplier_name;
		this.image = image;
		this.price = price;
	}

	@Id // it indicate the primary key for the table
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY) /**
														 * generation type for
														 * id can be auto or
														 * identity
														 **/
	private int id;
	@Column
	@NotEmpty(message = "Please enter product name")
	private String product_name;
	@Column
	@NotEmpty(message = "Please enter description")
	private String description;
	@Column
	@NotNull(message = "Please enter Price")
	private int price;

	@Column
	@NotNull(message = "Please enter Quantity")
	private int quantity;
	@Column
	@NotEmpty(message = "Please enter  supplier name")
	private String supplier_name;
	@Column
	@NotEmpty(message = "Please enter category name")
	private String category_name;
	@Column
	@Transient
	private MultipartFile image;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "c_id")
	private CategoryInfo category_fk;

	// getter and setter methods for all the fields
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public CategoryInfo getCategory_fk() {
		return category_fk;
	}

	public void setCategory_fk(CategoryInfo category_fk) {
		this.category_fk = category_fk;
	}
}
