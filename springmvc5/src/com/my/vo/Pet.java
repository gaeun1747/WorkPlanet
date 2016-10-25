package com.my.vo;
/**
 * 자바빈즈 : 자바컴포넌트
 * -public class
 * -public 매개변수없는 생성자
 * -프로퍼티용 mv는 public이면 안됨
 * -프로퍼티용 public set/get메서드
 * @author pc
 *
 */
public class Pet {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}