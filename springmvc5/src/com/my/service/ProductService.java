package com.my.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dao.CategoryDAO;
import com.my.dao.ProductDAO;
import com.my.exception.SelectException;
import com.my.vo.Category;
import com.my.vo.Product;
@Service("productService")
public class ProductService {
	@Autowired
	private ProductDAO productDao;
	@Autowired
	private CategoryDAO categoryDao;
	
	public List<Product> findAll() throws SelectException{
		return productDao.selectAll();
	}
	public Product findByNo(String no) throws SelectException{		
		Product p = productDao.selectProductByNo(no);
		return p;
	}
	public List<Product> findByName(String word) throws SelectException{
		return productDao.selectProductsByLikeName("%" + word+"%");
	}
	public List<Product> findByCategory(String cate_no)  throws SelectException{
		return productDao.selectProductsByCategory(cate_no);
	}
	public List<Category> findCategoriesAll()  throws SelectException{	
		return categoryDao.selectAll();
	}
}
