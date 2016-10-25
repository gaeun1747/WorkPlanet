package com.my.dao;

public interface AccountDAO {
	public void add(String no, int amount)
			throws Exception;
	public void deposit(String no, int amount)
			throws Exception;
	public void withdraw(String no, int amount)
			throws Exception;
	public void transfer(String frno, String tono, int amount) throws Exception;
}