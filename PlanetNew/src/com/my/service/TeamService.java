package com.my.service;

import com.my.dao.TeamDAO;
import com.my.dao.TeamDAOOracle;
import com.my.exception.InsertException;
import com.my.exception.UpdateException;
import com.my.vo.Team;

public class TeamService {
	private TeamDAO dao;
	public TeamService() {
		dao = new TeamDAOOracle();
	}
	//팀생성
	public void register(Team t) throws InsertException{}
	//팀 삭제 status 수정
	public void delete(int team_id) throws UpdateException{}
	//팀 이름 수정
	public void update(Team t) throws UpdateException{}
}
