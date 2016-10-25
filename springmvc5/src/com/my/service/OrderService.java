package com.my.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dao.OrderDAO;
import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.vo.OrderInfo;
@Service("orderService")
public class OrderService {
	@Autowired
	private OrderDAO dao;
	
	public void register(OrderInfo info) throws InsertException{
		dao.insert(info);
	}
	public List<OrderInfo> findOrdersById(String id) throws SelectException{
		return dao.selectOrdersById(id);
	}
}