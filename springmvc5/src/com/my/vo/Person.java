package com.my.vo;

public class Person {
	private String name;
	private String tel;
/*	protected String name;
	protected String tel;*/	
	public Person(){ }
	public Person(String name, String tel){
		this.name = name;  this.tel=tel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
