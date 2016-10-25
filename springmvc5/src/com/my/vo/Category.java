package com.my.vo;

public class Category {
	private String cate_no;
	private String cate_name;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String cate_no, String cate_name) {
		super();
		this.cate_no = cate_no;
		this.cate_name = cate_name;
	}
	public String getCate_no() {
		return cate_no;
	}
	public void setCate_no(String cate_no) {
		this.cate_no = cate_no;
	}
	public String getCate_name() {
		return cate_name;
	}
	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}
	@Override
	public String toString() {
		return "Category [cate_no=" + cate_no + ", cate_name=" + cate_name + "]";
	}
	
}
