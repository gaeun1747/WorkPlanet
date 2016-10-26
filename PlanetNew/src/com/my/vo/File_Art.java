package com.my.vo;

public class File_Art {
	private int article_id;
	private int file_id;
	private String file_name;
	private char use_status;  //기본값Y 삭제N
	private ArticlePart articlepart; // 작성자, 날짜 VO
	
	// 기본생성자
	public File_Art() {
		super();
	}
	// 생성자
	public File_Art(int article_id, int file_id, String file_name, char use_status, ArticlePart articlepart) {
		super();
		this.article_id = article_id;
		this.file_id = file_id;
		this.file_name = file_name;
		this.use_status = use_status;
		this.articlepart = articlepart;
	}
	
	@Override
	public String toString() {
		return "File_Art [article_id=" + article_id + ", file_id=" + file_id + ", file_name=" + file_name
				+ ", use_status=" + use_status + ", articlepart=" + articlepart + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + article_id;
		result = prime * result + ((articlepart == null) ? 0 : articlepart.hashCode());
		result = prime * result + file_id;
		result = prime * result + ((file_name == null) ? 0 : file_name.hashCode());
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
		File_Art other = (File_Art) obj;
		if (article_id != other.article_id)
			return false;
		if (articlepart == null) {
			if (other.articlepart != null)
				return false;
		} else if (!articlepart.equals(other.articlepart))
			return false;
		if (file_id != other.file_id)
			return false;
		if (file_name == null) {
			if (other.file_name != null)
				return false;
		} else if (!file_name.equals(other.file_name))
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
	public int getFile_id() {
		return file_id;
	}
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
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