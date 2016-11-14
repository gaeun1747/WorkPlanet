package com.my.vo;

import java.util.List;

public class Nation {
	private int nation_id;
	private String nation_name;
	private char nation_status; // 공개Y 비공개N
	private char use_status; // 기본값Y 삭제N
	private List<N_Mem> nmems; // 팀멤버 객체
	// 기본생성자
	public Nation() {
		super();
	}
	//생성자
	public Nation(int nation_id, String nation_name, char nation_status, char use_status, List<N_Mem> nmems) {
		super();
		this.nation_id = nation_id;
		this.nation_name = nation_name;
		this.nation_status = nation_status;
		this.use_status = use_status;
		this.nmems = nmems;
	}
	
	@Override
	public String toString() {
		return "Nation [nation_id=" + nation_id + ", nation_name=" + nation_name + ", nation_status=" + nation_status
				+ ", use_status=" + use_status + ", nmems=" + nmems + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nation_id;
		result = prime * result + ((nation_name == null) ? 0 : nation_name.hashCode());
		result = prime * result + nation_status;
		result = prime * result + ((nmems == null) ? 0 : nmems.hashCode());
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
		Nation other = (Nation) obj;
		if (nation_id != other.nation_id)
			return false;
		if (nation_name == null) {
			if (other.nation_name != null)
				return false;
		} else if (!nation_name.equals(other.nation_name))
			return false;
		if (nation_status != other.nation_status)
			return false;
		if (nmems == null) {
			if (other.nmems != null)
				return false;
		} else if (!nmems.equals(other.nmems))
			return false;
		if (use_status != other.use_status)
			return false;
		return true;
	}
	
	// getter, setter method
	public int getNation_id() {
		return nation_id;
	}
	public void setNation_id(int nation_id) {
		this.nation_id = nation_id;
	}
	public String getNation_name() {
		return nation_name;
	}
	public void setNation_name(String nation_name) {
		this.nation_name = nation_name;
	}
	public char getNation_status() {
		return nation_status;
	}
	public void setNation_status(char nation_status) {
		this.nation_status = nation_status;
	}
	public char getUse_status() {
		return use_status;
	}
	public void setUse_status(char use_status) {
		this.use_status = use_status;
	}
	public List<N_Mem> getNmems() {
		return nmems;
	}
	public void setNmems(List<N_Mem> nmems) {
		this.nmems = nmems;
	}
	
}
