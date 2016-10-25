package com.my.dao;

import com.my.exception.InsertException;
import com.my.exception.UpdateException;
import com.my.vo.Team;

public interface TeamDAO {
	public void insertTeam(Team t) throws InsertException;
	public void deleteTeam(Team t) throws UpdateException;
	public void updateTeam(Team t) throws UpdateException;
}
