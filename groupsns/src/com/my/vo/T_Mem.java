package com.my.vo;

public class T_Mem {
	private int team_id;
	private char member_status; // Y팀마스터 N팀원
	private char use_status; // 기본값Y 삭제N
	private P_Mem pmem; // 플래닛멤버 객체
	// 기본생성자
	public T_Mem() {
		super();
	}
	// 생성자
	public T_Mem(int team_id, char member_status, char use_status, P_Mem pmem) {
		super();
		this.team_id = team_id;
		this.member_status = member_status;
		this.use_status = use_status;
		this.pmem = pmem;
	}
	
	@Override
	public String toString() {
		return "T_Mem [team_id=" + team_id + ", member_status=" + member_status + ", use_status=" + use_status
				+ ", pmem=" + pmem + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + member_status;
		result = prime * result + ((pmem == null) ? 0 : pmem.hashCode());
		result = prime * result + team_id;
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
		T_Mem other = (T_Mem) obj;
		if (member_status != other.member_status)
			return false;
		if (pmem == null) {
			if (other.pmem != null)
				return false;
		} else if (!pmem.equals(other.pmem))
			return false;
		if (team_id != other.team_id)
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
	public char getMember_status() {
		return member_status;
	}
	public void setMember_status(char member_status) {
		this.member_status = member_status;
	}
	public char getUse_status() {
		return use_status;
	}
	public void setUse_status(char use_status) {
		this.use_status = use_status;
	}
	public P_Mem getPmem() {
		return pmem;
	}
	public void setPmem(P_Mem pmem) {
		this.pmem = pmem;
	}
}
