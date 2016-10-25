package com.my.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dao.CustomerDAO;
import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.vo.Customer;
@Service("customerService")
public class CustomerService {
	@Autowired CustomerDAO dao;
	
	public Customer findById(String id) throws SelectException{
		return dao.selectById(id);
	}
	public void register(Customer c) throws InsertException{
		dao.insert(c);
	}
	public Customer login(String id, String pwd) throws SelectException{
		try{	
			Customer c = dao.selectById(id);			
			if(c.getPassword().equals(pwd)){//pwd값과 DB의 password값비교
				return c;
			}else{
				throw new SelectException("로그인 실패");
			}
		}catch(SelectException e){throw new SelectException("로그인 실패");
		}
	}
}
