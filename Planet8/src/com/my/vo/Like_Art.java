package com.my.vo;

public class Like_Art {
	private int article_id;
	private String like_member_id;
	private char use_status;  // 기본값Y, 삭제N
	private Member member;  // 좋아요 누른 사람의 Member 객체
	
	// 기본생성자
	public Like_Art() {
		super();
	}
	// 생성자
	public Like_Art(int article_id, String like_member_id, char use_status, Member member) {
		super();
		this.article_id = article_id;
		this.like_member_id = like_member_id;
		this.use_status = use_status;
		this.member = member;
	}

	@Override
	public String toString() {
		return "Like_Art [article_id=" + article_id + ", like_member_id=" + like_member_id + ", use_status="
				+ use_status + ", member=" + member + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + article_id;
		result = prime * result + ((like_member_id == null) ? 0 : like_member_id.hashCode());
		result = prime * result + ((member == null) ? 0 : member.hashCode());
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
		Like_Art other = (Like_Art) obj;
		if (article_id != other.article_id)
			return false;
		if (like_member_id == null) {
			if (other.like_member_id != null)
				return false;
		} else if (!like_member_id.equals(other.like_member_id))
			return false;
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		if (use_status != other.use_status)
			return false;
		return true;
	}

	// setter, getter method
	public int getArticle_id() {
		return article_id;
	}
	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}
	public String getLike_member_id() {
		return like_member_id;
	}
	public void setLike_member_id(String like_member_id) {
		this.like_member_id = like_member_id;
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
}