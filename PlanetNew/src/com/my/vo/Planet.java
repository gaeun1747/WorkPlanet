package com.my.vo;

public class Planet {
	private int planet_id;
	private String planet_name;
	private char use_status; // 기본값Y, 삭제N
	// 기본생성자
	public Planet() {
		super();
	}
	// 생성자
	public Planet(int planet_id, String planet_name, char use_status) {
		super();
		this.planet_id = planet_id;
		this.planet_name = planet_name;
		this.use_status = use_status;
	}
	
	@Override
	public String toString() {
		return "Planet [planet_id=" + planet_id + ", planet_name=" + planet_name + ", use_status=" + use_status + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + planet_id;
		result = prime * result + ((planet_name == null) ? 0 : planet_name.hashCode());
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
		Planet other = (Planet) obj;
		if (planet_id != other.planet_id)
			return false;
		if (planet_name == null) {
			if (other.planet_name != null)
				return false;
		} else if (!planet_name.equals(other.planet_name))
			return false;
		if (use_status != other.use_status)
			return false;
		return true;
	}
	
	// getter, setter method
	public int getPlanet_id() {
		return planet_id;
	}
	public void setPlanet_id(int planet_id) {
		this.planet_id = planet_id;
	}
	public String getPlanet_name() {
		return planet_name;
	}
	public void setPlanet_name(String planet_name) {
		this.planet_name = planet_name;
	}
	public char getUse_status() {
		return use_status;
	}
	public void setUse_status(char use_status) {
		this.use_status = use_status;
	}
}
