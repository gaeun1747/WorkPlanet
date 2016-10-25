package com.my.vo;

import java.util.Date;

public class P_Mem {
	private String nickname;
	private Date reg_date;
	private char member_status; // Y마스터 N일반회원
	private char use_status; //기본값Y, 삭제N
	private Member member; // member객체
	private Planet planet; // planet객체
	// 기본생성자
	public P_Mem() {
		super();
	}
	// 생성자
	public P_Mem(String nickname, Date reg_date, char member_status, char use_status, Member member, Planet planet) {
		super();
		this.nickname = nickname;
		this.reg_date = reg_date;
		this.member_status = member_status;
		this.use_status = use_status;
		this.member = member;
		this.planet = planet;
	}
	
	@Override
	public String toString() {
		return "P_Mem [nickname=" + nickname + ", reg_date=" + reg_date + ", member_status=" + member_status
				+ ", use_status=" + use_status + ", member=" + member + ", planet=" + planet + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((member == null) ? 0 : member.hashCode());
		result = prime * result + member_status;
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((planet == null) ? 0 : planet.hashCode());
		result = prime * result + ((reg_date == null) ? 0 : reg_date.hashCode());
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
		P_Mem other = (P_Mem) obj;
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		if (member_status != other.member_status)
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (planet == null) {
			if (other.planet != null)
				return false;
		} else if (!planet.equals(other.planet))
			return false;
		if (reg_date == null) {
			if (other.reg_date != null)
				return false;
		} else if (!reg_date.equals(other.reg_date))
			return false;
		if (use_status != other.use_status)
			return false;
		return true;
	}
	
	// getter, setter method
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
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
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
}
