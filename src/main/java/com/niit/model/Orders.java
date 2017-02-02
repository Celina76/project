package com.niit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "o")
public class Orders implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Column

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ord_id;
	@OneToOne
	@JoinColumn(name = "cart_id")
	private Cart cartid_fk;
	@OneToOne
	@JoinColumn(name = "s_id")
	private Shipping sid_fk;
	@OneToOne
	@JoinColumn(name="email")
	private UserInfo email_fk;
	@Column
	@Temporal(TemporalType.DATE)
	private Date o_date;
	@Column
	@Temporal(TemporalType.TIME)
	private Date o_time;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dis_date;
	@Column
	@Temporal(TemporalType.TIME)
	private Date dis_time;
	@Column
	@Temporal(TemporalType.DATE)
	private Date del_date;
	@Column
	@Temporal(TemporalType.TIME)
	private Date del_time;
	@Column
	private String del_status;
	public Orders(int ord_id, Cart cartid_fk, Shipping sid_fk, Date o_date, Date o_time, Date dis_date, Date dis_time,
			Date del_date, Date del_time, String del_status,UserInfo email_fk) {
		super();
		this.ord_id = ord_id;
		this.cartid_fk = cartid_fk;
		this.sid_fk = sid_fk;
		this.o_date = o_date;
		this.o_time = o_time;
		this.dis_date = dis_date;
		this.dis_time = dis_time;
		this.del_date = del_date;
		this.del_time = del_time;
		this.del_status = del_status;
		this.email_fk=email_fk;

	}

	public int getOrd_id() {
		return ord_id;
	}

	public void setOrd_id(int ord_id) {
		this.ord_id = ord_id;
	}

	public Cart getCartid_fk() {
		return cartid_fk;
	}

	public void setCartid_fk(Cart cartid_fk) {
		this.cartid_fk = cartid_fk;
	}

	public Shipping getSid_fk() {
		return sid_fk;
	}

	public void setSid_fk(Shipping sid_fk) {
		this.sid_fk = sid_fk;
	}

	public Date getO_date() {
		return o_date;
	}

	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}

	public Date getO_time() {
		return o_time;
	}

	public void setO_time(Date o_time) {
		this.o_time = o_time;
	}

	public Date getDis_date() {
		return dis_date;
	}

	public void setDis_date(Date dis_date) {
		this.dis_date = dis_date;
	}

	public Date getDis_time() {
		return dis_time;
	}

	public void setDis_time(Date dis_time) {
		this.dis_time = dis_time;
	}

	public Date getDel_date() {
		return del_date;
	}

	public void setDel_date(Date del_date) {
		this.del_date = del_date;
	}

	public Date getDel_time() {
		return del_time;
	}

	public void setDel_time(Date del_time) {
		this.del_time = del_time;
	}

	public String getDel_status() {
		return del_status;
	}

	public void setDel_status(String del_status) {
		this.del_status = del_status;
	}

	public UserInfo getEmail_fk() {
		return email_fk;
	}

	public void setEmail_fk(UserInfo email_fk) {
		this.email_fk = email_fk;
	}


}
