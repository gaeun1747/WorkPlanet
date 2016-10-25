package com.my.dao;

import java.util.List;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.vo.Product;

public interface ProductDAO {
	/**
	 * 상품을 저장소에 누적하고 총상품수를 1증가한다.
	 * 단,중복된 상품은 "이미존재하는 상품입니다"메시지를 갖는 
	 *  InsertException예외발생한다.   
	 * 중복된 상품이란 상품번호가 같은 상품객체를 말한다.
	 * @param p 저장할 상품
	 * @throws InsertException
	 */
	public abstract void insert(Product p) throws InsertException;
	/**
	 * 상품번호에 해당하는 상품객체를 저장소에서 찾아 반환한다.
	 * 단, 상품번호에 해당 상품이 없을 경우 null값을 반환한다.
	 * @param prod_no 상품번호
	 * @return 상품객체
	 * @throws SelectException
	 */
	Product selectProductByNo(String no) throws SelectException;
	/**
	 * 저장소에 저장되어있는 상품들을 반환한다.
	 * @return
	 */
	List<Product> selectAll() throws SelectException;
	
	/**
	 * 상품명에 해당 단어를 포함하는 상품들을 찾아 반환한다 
	 * @param word 해당단어
	 * @return 상품이 없을 경우 index가 0인 리스트를 반환한다.
	 */
	List<Product> selectProductsByLikeName(String word) throws SelectException;
	/**
	 * 카테고리별 상품들을 찾아 반환한다
	 * @param cate_no
	 * @return 상품이 없을 경우 index가 0인 리스트를 반환한다.
	 * @throws SelectException 
	 */
	List<Product> selectProductsByCategory(String cate_no) throws SelectException;
	
	
	
}