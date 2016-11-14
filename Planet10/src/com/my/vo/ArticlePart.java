package com.my.vo;

import java.util.Date;

public class ArticlePart {
	private int article_id;
	private String member_id;  // 글쓴사람 ID
	private Date art_reg_date;  //등록일
	private Date art_edit_date;  //수정일
	
	// 기본생성자
	public ArticlePart() {
		super();
	}
	// 생성자
	public ArticlePart(int article_id, String member_id, Date art_reg_date, Date art_edit_date) {
		super();
		this.article_id = article_id;
		this.member_id = member_id;
		this.art_reg_date = art_reg_date;
		this.art_edit_date = art_edit_date;
	}
	
	@Override
	public String toString() {
		return "ArticlePart [article_id=" + article_id + ", member_id=" + member_id + ", art_reg_date=" + art_reg_date
				+ ", art_edit_date=" + art_edit_date + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((art_edit_date == null) ? 0 : art_edit_date.hashCode());
		result = prime * result + ((art_reg_date == null) ? 0 : art_reg_date.hashCode());
		result = prime * result + article_id;
		result = prime * result + ((member_id == null) ? 0 : member_id.hashCode());
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
		ArticlePart other = (ArticlePart) obj;
		if (art_edit_date == null) {
			if (other.art_edit_date != null)
				return false;
		} else if (!art_edit_date.equals(other.art_edit_date))
			return false;
		if (art_reg_date == null) {
			if (other.art_reg_date != null)
				return false;
		} else if (!art_reg_date.equals(other.art_reg_date))
			return false;
		if (article_id != other.article_id)
			return false;
		if (member_id == null) {
			if (other.member_id != null)
				return false;
		} else if (!member_id.equals(other.member_id))
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
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public Date getArt_reg_date() {
		return art_reg_date;
	}
	public void setArt_reg_date(Date art_reg_date) {
		this.art_reg_date = art_reg_date;
	}
	public Date getArt_edit_date() {
		return art_edit_date;
	}
	public void setArt_edit_date(Date art_edit_date) {
		this.art_edit_date = art_edit_date;
	}
}