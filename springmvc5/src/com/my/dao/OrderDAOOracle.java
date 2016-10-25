package com.my.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.sql.MyConnection;
import com.my.vo.OrderInfo;
import com.my.vo.OrderLine;
import com.my.vo.Product;
@Repository("orderDAO")
public class OrderDAOOracle implements OrderDAO {
	@Autowired
	private SqlSession sqlSession;
	@Override
	public void insert(OrderInfo info) throws InsertException {
		try{
			//order_seq.nextval대신 최대주문번호 얻기
			int order_no = sqlSession.selectOne("OrderMapper.selectMaxInfoNo");
			info.setOrder_no(order_no);
			
			HashMap<String, Object>mapInfo = new HashMap<String, Object>();
			mapInfo.put("order_no", order_no);
			mapInfo.put("id", info.getCustomer().getId());			
			//sqlSession.insert("OrderMapper.insertOrderInfo", info.getCustomer().getId());
			sqlSession.insert("OrderMapper.insertOrderInfo", mapInfo);
			
			List<OrderLine> lines = info.getLines();			
			for(int i=1; i<=lines.size(); i++){
				OrderLine line = lines.get(i-1);
				HashMap<String, Object> map = new HashMap<String, Object>(); 
				map.put("order_no", order_no);
				map.put("line_no", i);
				map.put("prod_no", line.getProduct().getProd_no());
				map.put("quantity", i);
				sqlSession.insert("OrderMapper.insertOrderLine", map);
			}
			System.out.println("INSERT ORDER SUCCESS");
			//sqlSession.commit();
		}catch(Exception e){
			throw new InsertException(e.getMessage());
		}finally {
			
		}
	}

	@Override
	public List<OrderInfo> selectOrdersById(String id) throws SelectException {
		try{
			return sqlSession.selectList("OrderMapper.selectOrdersById",id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SelectException(e.getMessage());
		}finally {
			
		}	
	}
}