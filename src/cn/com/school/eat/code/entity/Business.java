package cn.com.school.eat.code.entity;

public class Business {

	private String business_id;
	private String business_name;
	private String password;
	private String status;
	private String resturant_id;
	
	public String getResturant_id() {
		return resturant_id;
	}
	public void setResturant_id(String resturant_id) {
		this.resturant_id = resturant_id;
	}
	public String getBusiness_id() {
		return business_id;
	}
	public void setBusiness_id(String business_id) {
		this.business_id = business_id;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
