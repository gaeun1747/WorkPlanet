package com.my.vo;

public class Customer extends Person {
	private String id;
	private String password;
	
	public Customer(){
		//부모의 매개변수없는 생성자가 자동호출됨	
		//super(); 
	}
	public Customer(String id, String password){		
		this(id, password, null, null);
	}
	public Customer(String id, String password, String name, String tel){		
		super(name, tel);		
		this.id = id;
		this.password = password;
		//this.name = name;
		//this.tel = tel;
		//setName(name);  setTel(tel);
	}
	
	@Override
	public String toString(){
		return id+":"+password+":"+ getName()+":" + getTel();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
