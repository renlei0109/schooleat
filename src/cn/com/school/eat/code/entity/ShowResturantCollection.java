package cn.com.school.eat.code.entity;

import java.io.Serializable;

public class ShowResturantCollection implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String img_url;
	private String resturant_name;
	private String resturant_id;
	private String beginmoney;
	private String total_sell;
	public ShowResturantCollection() {

	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getResturant_name() {
		return resturant_name;
	}

	public void setResturant_name(String resturant_name) {
		this.resturant_name = resturant_name;
	}

	public String getResturant_id() {
		return resturant_id;
	}

	public void setResturant_id(String resturant_id) {
		this.resturant_id = resturant_id;
	}

	public String getBeginmoney() {
		return beginmoney;
	}

	public void setBeginmoney(String beginmoney) {
		this.beginmoney = beginmoney;
	}

	public String getTotal_sell() {
		return total_sell;
	}

	public void setTotal_sell(String total_sell) {
		this.total_sell = total_sell;
	}
}
