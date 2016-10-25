package com.my.vo;
public class OrderLine {
	private int order_no;
	//private OrderInfo info;
	private int line_no;
	//private String line_prod_no;
	private Product product;
	private int quantity;
	public OrderLine() {
		super();
	}
	public OrderLine(int order_no, int line_no, Product product, int quantity) {
		super();
		this.order_no = order_no;
		this.line_no = line_no;
		this.product = product;
		this.quantity = quantity;
	}
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public int getLine_no() {
		return line_no;
	}
	public void setLine_no(int line_no) {
		this.line_no = line_no;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
	
}