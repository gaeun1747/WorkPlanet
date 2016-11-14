
package com.my.vo;

import java.util.Date;

public class Plan_Art {
	private int article_id;
	private String plan_contents;
	private Date plan_startdate;
	private Date plan_enddate;
	private char use_status; //기본값Y 삭제N
	private ArticlePart articlepart; // 작성자, 날짜 VO
	
	// 기본생성자
	public Plan_Art() {
		super();
	}
	// 생성자
	public Plan_Art(int article_id, String plan_contents, Date plan_startdate, Date plan_enddate, char use_status,
			ArticlePart articlepart) {
		super();
		this.article_id = article_id;
		this.plan_contents = plan_contents;
		this.plan_startdate = plan_startdate;
		this.plan_enddate = plan_enddate;
		this.use_status = use_status;
		this.articlepart = articlepart;
	}
	
	@Override
	public String toString() {
		return "Plan_Art [article_id=" + article_id + ", plan_contents=" + plan_contents + ", plan_startdate="
				+ plan_startdate + ", plan_enddate=" + plan_enddate + ", use_status=" + use_status + ", articlepart="
				+ articlepart + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + article_id;
		result = prime * result + ((articlepart == null) ? 0 : articlepart.hashCode());
		result = prime * result + ((plan_contents == null) ? 0 : plan_contents.hashCode());
		result = prime * result + ((plan_enddate == null) ? 0 : plan_enddate.hashCode());
		result = prime * result + ((plan_startdate == null) ? 0 : plan_startdate.hashCode());
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
		Plan_Art other = (Plan_Art) obj;
		if (article_id != other.article_id)
			return false;
		if (articlepart == null) {
			if (other.articlepart != null)
				return false;
		} else if (!articlepart.equals(other.articlepart))
			return false;
		if (plan_contents == null) {
			if (other.plan_contents != null)
				return false;
		} else if (!plan_contents.equals(other.plan_contents))
			return false;
		if (plan_enddate == null) {
			if (other.plan_enddate != null)
				return false;
		} else if (!plan_enddate.equals(other.plan_enddate))
			return false;
		if (plan_startdate == null) {
			if (other.plan_startdate != null)
				return false;
		} else if (!plan_startdate.equals(other.plan_startdate))
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
	public String getPlan_contents() {
		return plan_contents;
	}
	public void setPlan_contents(String plan_contents) {
		this.plan_contents = plan_contents;
	}
	public Date getPlan_startdate() {
		return plan_startdate;
	}
	public void setPlan_startdate(Date plan_startdate) {
		this.plan_startdate = plan_startdate;
	}
	public Date getPlan_enddate() {
		return plan_enddate;
	}
	public void setPlan_enddate(Date plan_enddate) {
		this.plan_enddate = plan_enddate;
	}
	public char getUse_status() {
		return use_status;
	}
	public void setUse_status(char use_status) {
		this.use_status = use_status;
	}
	public ArticlePart getArticlepart() {
		return articlepart;
	}
	public void setArticlepart(ArticlePart articlepart) {
		this.articlepart = articlepart;
	}
}