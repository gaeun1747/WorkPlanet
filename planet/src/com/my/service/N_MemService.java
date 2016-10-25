package com.my.service;

import com.my.dao.N_MemDAO;
import com.my.dao.N_MemDAOOracle;
import com.my.vo.Article;
import com.my.vo.N_Mem;

public class N_MemService {
	private N_MemDAO dao;
	public N_MemService() {
		dao = new N_MemDAOOracle();
	}
	// 그룹 가입
	public void register(N_Mem nmem){
	}
	// 그룹멤버
}
