package com.niit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Component
@Table(name="c")
public class CartItems implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartItems_id;
	@ManyToOne
	@JoinColumn(name = "cart_id")
	@JsonIgnore
	private Cart cart_id1;
	
	private int quantity;
	@ManyToOne
	@JoinColumn(name = "id")
	private ProductInfo id_fk;
	
	private int totalPrice;
	public CartItems(){
		
	}
	public CartItems(int cartItems_id, Cart cart_id1, int quantity, ProductInfo id_fk, int totalPrice) {
		super();
		this.cartItems_id = cartItems_id;
		this.cart_id1 = cart_id1;
		this.quantity = quantity;
		this.id_fk = id_fk;
		this.totalPrice = totalPrice;
	}
	public int getCartItems_id() {
		return cartItems_id;
	}
	public void setCartItems_id(int cartItems_id) {
		this.cartItems_id = cartItems_id;
	}
	public Cart getCart_id1() {
		return cart_id1;
	}
	public void setCart_id1(Cart cart_id1) {
		this.cart_id1 = cart_id1;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ProductInfo getId_fk() {
		return id_fk;
	}
	public void setId_fk(ProductInfo id_fk) {
		this.id_fk = id_fk;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
}
