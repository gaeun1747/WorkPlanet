package com.my.dao;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.vo.Customer;

public interface CustomerDAO {
	/**
	 * 아이디에 해당하는 고객정보를 검새하여 반환한다
	 * @param id 아이디
	 * @return 고객객체
	 * @throws SelectException 
	 * DB와의 Network오류가 발생하거나
	 * 아이디에 해당 고객이 없으면 SelectException발생한다.
	 */
	public Customer selectById(String id) 
			   throws SelectException;

	public void insert(Customer c) throws InsertException;
}
