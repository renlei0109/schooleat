package cn.com.school.eat.code.entity;

import java.io.Serializable;

public class Dish_Rec implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dish_id;
	private String resturant_id;
	private String dish_name;
	private double price;
	private double sale_price;
	private int sales;
	private String img_url;

	private String resturant_name;

	public Dish_Rec() {

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

	public String getDish_name() {
		return dish_name;
	}

	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSale_price() {
		return sale_price;
	}

	public void setSale_price(double sale_price) {
		this.sale_price = sale_price;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
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

}
