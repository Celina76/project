package com.niit.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cart")
public class Cart implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cart_id;
	private double total;
	private int quantity;
	private String date_time;
	@OneToOne
	@JoinColumn(name = "email")
	@JsonIgnore
	private UserInfo email_fk;
	@ManyToOne
	@JoinColumn(name = "id")
	private ProductInfo product_fk;
	@OneToMany(mappedBy = "cart_id1", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItems> cartItems;
	@OneToOne
	@JoinColumn(name="user_id")
	private UserInfo register_fk;
	public Cart(){}
	public Cart(int cart_id, double total, int quantity, String date_time, UserInfo email_fk,ProductInfo product_fk,UserInfo register_fk) {
		super();
		this.cart_id = cart_id;
		this.total = total;
		this.quantity = quantity;
		this.date_time = date_time;
		this.email_fk = email_fk;
		this.product_fk=product_fk;
		this.register_fk=register_fk;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDate_time() {
		return date_time;
	}
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	public UserInfo getEmail_fk() {
		return email_fk;
	}
	public void setAddress_fk(UserInfo email_fk) {
		this.email_fk = email_fk;
	}
	public ProductInfo getProduct_fk() {
		return product_fk;
	}
	public void setProduct_fk(ProductInfo product_fk) {
		this.product_fk = product_fk;
	}
	public List<CartItems> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}
	public UserInfo getRegister_fk() {
		return register_fk;
	}
	public void setRegister_fk(UserInfo register_fk) {
		this.register_fk = register_fk;
	}

}
