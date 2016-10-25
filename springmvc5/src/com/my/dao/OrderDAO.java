package com.my.dao;

import java.util.List;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.vo.OrderInfo;

public interface OrderDAO {
	/**
	 * 주문기본정보와 상세정보를 추가한다
	 * @param info
	 * @throws InsertException
	 */
	public void insert(OrderInfo info)  throws InsertException;
	/**
	 * 주문자ID가 주문한 기본정보와 상세정보를 반환한다
	 * @param id 주문자아이디
	 * @return 
	 * @throws SelectException
	 */
	public List<OrderInfo>selectOrdersById(String id) throws SelectException;
}