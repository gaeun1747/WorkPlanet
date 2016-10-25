package com.my.vo;

import java.util.Date;
public class Product {
	private String prod_no;
	private String prod_name;
	private int prod_price;
	private String prod_mf_dt;
	private Date prod_reg_dt;
	//private String cate_no; 
	private Category cate;//assocation relationship 참조연관관계
	
	public Product() {	}		
	public Product(String prod_no, String prod_name, int prod_price) {
		this(prod_no, prod_name, prod_price, null, null, null);
	}
	public Product(String prod_no, String prod_name, int prod_price, String cate_no) {
		this(prod_no, prod_name, prod_price, null, null, new Category(cate_no, null));
	}
	
	
	/*
	 * 
	 */
	/*public Product(String prod_no, String prod_name, int prod_price,
			      String prod_mf_dt, Date prod_reg_dt, String cate_no) {
		super();
		this.prod_no = prod_no;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_mf_dt = prod_mf_dt;
		this.prod_reg_dt = prod_reg_dt;	
		this(prod_no, prod_name, prod_price, prod_mf_dt,prod_reg_dt, new Category(cate_no, null));
		//this.cate_no = cate_no;
	}*/
	public Product(String prod_no, String prod_name, int prod_price,
			      String prod_mf_dt, Date prod_reg_dt, Category cate){		
		super();
		
		this.prod_no = prod_no;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_mf_dt = prod_mf_dt;
		this.prod_reg_dt = prod_reg_dt;
		this.cate = cate;
	}
	public String toString(){		
		return cate + ":" + prod_no+":"+prod_name +":" + prod_price;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prod_no == null) ? 0 : prod_no.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (prod_no == null) {
			if (other.prod_no != null)
				return false;
		} else if (!prod_no.equals(other.prod_no))
			return false;
		return true;
	}
	public String getProd_no() {
		return prod_no;
	}
	public void setProd_no(String prod_no) {
		this.prod_no = prod_no;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getProd_price() {
		return prod_price;
	}
	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	public String getProd_mf_dt() {
		return prod_mf_dt;
	}
	public void setProd_mf_dt(String prod_mf_dt) {
		this.prod_mf_dt = prod_mf_dt;
	}
	public Date getProd_reg_dt() {
		return prod_reg_dt;
	}
	public void setProd_reg_dt(Date prod_reg_dt) {
		this.prod_reg_dt = prod_reg_dt;
	}
	/*public String getCate_no() {
		return cate_no;
	}
	public void setCate_no(String cate_no) {
		this.cate_no = cate_no;
	}*/
	public Category getCate() {
		return cate;
	}
	public void setCate(Category cate) {
		this.cate = cate;
	}
}