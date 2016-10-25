package com.my.vo;
import java.util.Date;
import java.util.List;
public class OrderInfo {
	private int order_no;
	private Customer customer;
	private java.util.Date order_dt;
	private List<OrderLine> lines;
	public OrderInfo() {}
	public OrderInfo(int order_no, Customer customer, Date order_dt, List<OrderLine> lines) {
		super();
		this.order_no = order_no;
		this.customer = customer;
		this.order_dt = order_dt;
		this.lines = lines;
	}
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public java.util.Date getOrder_dt() {
		return order_dt;
	}
	public void setOrder_dt(java.util.Date order_dt) {
		this.order_dt = order_dt;
	}
	public List<OrderLine> getLines() {
		return lines;
	}
	public void setLines(List<OrderLine> lines) {
		this.lines = lines;
	}	
}