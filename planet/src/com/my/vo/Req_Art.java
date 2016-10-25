package com.my.vo;

public class Req_Art {
	private int article_id;
	private String resp_user_id;  // 담당자id
	private int req_status;  // 0요청 1진행 2완료
	private String req_contents;
	private char use_status;  //기본값Y 삭제N
	// 기본생성자
	public Req_Art() {
		super();
	}
	// 생성자
	public Req_Art(int article_id, String resp_user_id, int req_status, String req_contents, char use_status) {
		super();
		this.article_id = article_id;
		this.resp_user_id = resp_user_id;
		this.req_status = req_status;
		this.req_contents = req_contents;
		this.use_status = use_status;
	}
	
	@Override
	public String toString() {
		return "Req_Art [article_id=" + article_id + ", resp_user_id=" + resp_user_id + ", req_status=" + req_status
				+ ", req_contents=" + req_contents + ", use_status=" + use_status + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + article_id;
		result = prime * result + ((req_contents == null) ? 0 : req_contents.hashCode());
		result = prime * result + req_status;
		result = prime * result + ((resp_user_id == null) ? 0 : resp_user_id.hashCode());
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
		Req_Art other = (Req_Art) obj;
		if (article_id != other.article_id)
			return false;
		if (req_contents == null) {
			if (other.req_contents != null)
				return false;
		} else if (!req_contents.equals(other.req_contents))
			return false;
		if (req_status != other.req_status)
			return false;
		if (resp_user_id == null) {
			if (other.resp_user_id != null)
				return false;
		} else if (!resp_user_id.equals(other.resp_user_id))
			return false;
		if (use_status != other.use_status)
			return false;
		return true;
	}
	
	// getter, setter method
	public int getArticle_id() {
		return article_id;
	}
	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}
	public String getResp_user_id() {
		return resp_user_id;
	}
	public void setResp_user_id(String resp_user_id) {
		this.resp_user_id = resp_user_id;
	}
	public int getReq_status() {
		return req_status;
	}
	public void setReq_status(int req_status) {
		this.req_status = req_status;
	}
	public String getReq_contents() {
		return req_contents;
	}
	public void setReq_contents(String req_contents) {
		this.req_contents = req_contents;
	}
	public char getUse_status() {
		return use_status;
	}
	public void setUse_status(char use_status) {
		this.use_status = use_status;
	}
}
