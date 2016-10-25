package com.my.vo;

import java.util.Date;
import java.util.List;

public class Article {
	private int article_id;
	private String member_id; 
	private int nation_id;
	private int planet_id;
	private Date art_reg_date;  //등록일
	private Date art_edit_date;  //수정일
	private String art_contents;  //게시글 내용
	private char use_status;  //기본값Y 삭제N
	private int imp_status;  //중요도. 0일반 1긴급 2중요
	private char notice_status;  //공지. 0일반 1공지
	private int grp;  // 원글 article_id
	private int seq;  // 1원글 2, 3...댓글
	private int lvl;  // 0원글 1댓글 (2대댓글)
	private Plan_Art planart;
	private Req_Art reqart;
	private List<Like_Art> likeart;
	private List<File_Art> fileart;
	// 기본생성자
	public Article() {
		super();
	}
	// 생성자
	public Article(int article_id, String member_id, int nation_id, int planet_id, Date art_reg_date,
			Date art_edit_date, String art_contents, char use_status, int imp_status, char notice_status, int grp,
			int seq, int lvl, Plan_Art planart, Req_Art reqart, List<Like_Art> likeart, List<File_Art> fileart) {
		super();
		this.article_id = article_id;
		this.member_id = member_id;
		this.nation_id = nation_id;
		this.planet_id = planet_id;
		this.art_reg_date = art_reg_date;
		this.art_edit_date = art_edit_date;
		this.art_contents = art_contents;
		this.use_status = use_status;
		this.imp_status = imp_status;
		this.notice_status = notice_status;
		this.grp = grp;
		this.seq = seq;
		this.lvl = lvl;
		this.planart = planart;
		this.reqart = reqart;
		this.likeart = likeart;
		this.fileart = fileart;
	}
	
	@Override
	public String toString() {
		return "Article [article_id=" + article_id + ", member_id=" + member_id + ", nation_id=" + nation_id
				+ ", planet_id=" + planet_id + ", art_reg_date=" + art_reg_date + ", art_edit_date=" + art_edit_date
				+ ", art_contents=" + art_contents + ", use_status=" + use_status + ", imp_status=" + imp_status
				+ ", notice_status=" + notice_status + ", grp=" + grp + ", seq=" + seq + ", lvl=" + lvl + ", planart="
				+ planart + ", reqart=" + reqart + ", likeart=" + likeart + ", fileart=" + fileart + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((art_contents == null) ? 0 : art_contents.hashCode());
		result = prime * result + ((art_edit_date == null) ? 0 : art_edit_date.hashCode());
		result = prime * result + ((art_reg_date == null) ? 0 : art_reg_date.hashCode());
		result = prime * result + article_id;
		result = prime * result + ((fileart == null) ? 0 : fileart.hashCode());
		result = prime * result + grp;
		result = prime * result + imp_status;
		result = prime * result + ((likeart == null) ? 0 : likeart.hashCode());
		result = prime * result + lvl;
		result = prime * result + ((member_id == null) ? 0 : member_id.hashCode());
		result = prime * result + nation_id;
		result = prime * result + notice_status;
		result = prime * result + ((planart == null) ? 0 : planart.hashCode());
		result = prime * result + planet_id;
		result = prime * result + ((reqart == null) ? 0 : reqart.hashCode());
		result = prime * result + seq;
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
		Article other = (Article) obj;
		if (art_contents == null) {
			if (other.art_contents != null)
				return false;
		} else if (!art_contents.equals(other.art_contents))
			return false;
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
		if (fileart == null) {
			if (other.fileart != null)
				return false;
		} else if (!fileart.equals(other.fileart))
			return false;
		if (grp != other.grp)
			return false;
		if (imp_status != other.imp_status)
			return false;
		if (likeart == null) {
			if (other.likeart != null)
				return false;
		} else if (!likeart.equals(other.likeart))
			return false;
		if (lvl != other.lvl)
			return false;
		if (member_id == null) {
			if (other.member_id != null)
				return false;
		} else if (!member_id.equals(other.member_id))
			return false;
		if (nation_id != other.nation_id)
			return false;
		if (notice_status != other.notice_status)
			return false;
		if (planart == null) {
			if (other.planart != null)
				return false;
		} else if (!planart.equals(other.planart))
			return false;
		if (planet_id != other.planet_id)
			return false;
		if (reqart == null) {
			if (other.reqart != null)
				return false;
		} else if (!reqart.equals(other.reqart))
			return false;
		if (seq != other.seq)
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
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public int getNation_id() {
		return nation_id;
	}
	public void setNation_id(int nation_id) {
		this.nation_id = nation_id;
	}
	public int getPlanet_id() {
		return planet_id;
	}
	public void setPlanet_id(int planet_id) {
		this.planet_id = planet_id;
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
	public String getArt_contents() {
		return art_contents;
	}
	public void setArt_contents(String art_contents) {
		this.art_contents = art_contents;
	}
	public char getUse_status() {
		return use_status;
	}
	public void setUse_status(char use_status) {
		this.use_status = use_status;
	}
	public int getImp_status() {
		return imp_status;
	}
	public void setImp_status(int imp_status) {
		this.imp_status = imp_status;
	}
	public char getNotice_status() {
		return notice_status;
	}
	public void setNotice_status(char notice_status) {
		this.notice_status = notice_status;
	}
	public int getGrp() {
		return grp;
	}
	public void setGrp(int grp) {
		this.grp = grp;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	public Plan_Art getPlanart() {
		return planart;
	}
	public void setPlanart(Plan_Art planart) {
		this.planart = planart;
	}
	public Req_Art getReqart() {
		return reqart;
	}
	public void setReqart(Req_Art reqart) {
		this.reqart = reqart;
	}
	public List<Like_Art> getLikeart() {
		return likeart;
	}
	public void setLikeart(List<Like_Art> likeart) {
		this.likeart = likeart;
	}
	public List<File_Art> getFileart() {
		return fileart;
	}
	public void setFileart(List<File_Art> fileart) {
		this.fileart = fileart;
	}
}
