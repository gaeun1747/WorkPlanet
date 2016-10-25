package com.my.dao;

import java.util.List;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.vo.Category;

public interface CategoryDAO {
	void insert(Category category) throws InsertException;
	List<Category> selectAll() throws SelectException;
	Category selectByNo(String cate_no) throws SelectException;
}
