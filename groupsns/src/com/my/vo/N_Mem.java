package com.my.vo;

import java.util.List;

public class N_Mem {
	private int nation_id;
	private char member_status; // 그룹마스터Y 일반N
	private char use_status; // 기본값Y 삭제N
	private P_Mem pmem; // 플래닛멤버 객체
	private List<Article> articles; // 멤버가 쓴 게시글 객체
	// 기본생성자
	public N_Mem() {
		super();
	}
	// 생성자
	public N_Mem(int nation_id, char member_status, char use_status, P_Mem pmem, List<Article> articles) {
		super();
		this.nation_id = nation_id;
		this.member_status = member_status;
		this.use_status = use_status;
		this.pmem = pmem;
		this.articles = articles;
	}
	
	@Override
	public String toString() {
		return "N_Mem [nation_id=" + nation_id + ", member_status=" + member_status + ", use_status=" + use_status
				+ ", pmem=" + pmem + ", articles=" + articles + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((articles == null) ? 0 : articles.hashCode());
		result = prime * result + member_status;
		result = prime * result + nation_id;
		result = prime * result + ((pmem == null) ? 0 : pmem.hashCode());
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
		N_Mem other = (N_Mem) obj;
		if (articles == null) {
			if (other.articles != null)
				return false;
		} else if (!articles.equals(other.articles))
			return false;
		if (member_status != other.member_status)
			return false;
		if (nation_id != other.nation_id)
			return false;
		if (pmem == null) {
			if (other.pmem != null)
				return false;
		} else if (!pmem.equals(other.pmem))
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
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
