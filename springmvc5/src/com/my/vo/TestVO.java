package com.my.vo;

import java.util.Date;

public class TestVO {
	private Date start;
	private Date end;
	private String empNo;
	//private Employee emp;
	public TestVO() {
		super();
	}
	public TestVO(Date start, Date end) {
		super();
		this.start = start;
		this.end = end;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	
}
