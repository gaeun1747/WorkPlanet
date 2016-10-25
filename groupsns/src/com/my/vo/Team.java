package com.my.vo;

import java.util.List;

public class Team {
	private int team_id;
	private String team_name;
	private char use_status; // 기본값Y 삭제N
	private List<T_Mem> tmems; // 팀멤버 객체
	// 기본생성자
	public Team() {
		super();
	}
	// 생성자
	public Team(int team_id, String team_name, char use_status, List<T_Mem> tmems) {
		super();
		this.team_id = team_id;
		this.team_name = team_name;
		this.use_status = use_status;
		this.tmems = tmems;
	}
	
	@Override
	public String toString() {
		return "Team [team_id=" + team_id + ", team_name=" + team_name + ", use_status=" + use_status + ", tmems="
				+ tmems + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + team_id;
		result = prime * result + ((team_name == null) ? 0 : team_name.hashCode());
		result = prime * result + ((tmems == null) ? 0 : tmems.hashCode());
		result = prime * result + use_status;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		if (team_id != other.team_id)
			return false;
		if (team_name == null) {
			if (other.team_name != null)
				return false;
		} else if (!team_name.equals(other.team_name))
			return false;
		if (tmems == null) {
			if (other.tmems != null)
				return false;
		} else if (!tmems.equals(other.tmems))
			return false;
		if (use_status != other.use_status)
			return false;
		return true;
	}
	
	// getter, setter method
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public char getUse_status() {
		return use_status;
	}
	public void setUse_status(char use_status) {
		this.use_status = use_status;
	}
	public List<T_Mem> getTmems() {
		return tmems;
	}
	public void setTmems(List<T_Mem> tmems) {
		this.tmems = tmems;
	}
}
