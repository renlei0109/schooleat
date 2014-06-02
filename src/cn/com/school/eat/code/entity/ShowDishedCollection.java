package cn.com.school.eat.code.entity;

import java.io.Serializable;

public class ShowDishedCollection implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dish_name;
	private String img_url;
	private String resturant_name;
	private String price;
	private String dish_id;
	private String resturant_id;

	public ShowDishedCollection() {

	}

	public String getDish_name() {
		return dish_name;
	}

	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDish_id() {
		return dish_id;
	}

	public void setDish_id(String dish_id) {
		this.dish_id = dish_id;
	}

	public String getResturant_id() {
		return resturant_id;
	}

	public void setResturant_id(String resturant_id) {
		this.resturant_id = resturant_id;
	}
}
