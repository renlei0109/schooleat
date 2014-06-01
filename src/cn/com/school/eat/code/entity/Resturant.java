package cn.com.school.eat.code.entity;

import java.util.Set;

public class Resturant {

	@Override
	public String toString() {
		return "Resturant [resturant_id=" + resturant_id + ", resturant_name="
				+ resturant_name + ", mobile=" + mobile + ", delivery="
				+ delivery + ", delivery_limit=" + delivery_limit
				+ ", delivery_time=" + delivery_time + ", x=" + x + ", y=" + y
				+ ", type=" + type + ", img_url=" + img_url + ", dishs="
				+ dishs + ", total_sell=" + total_sell + ", total_money="
				+ total_money + "]";
	}

	private String resturant_id;
	private String resturant_name;
	private String mobile;
	private String delivery;
	private String delivery_limit;
	private int delivery_time;
	private double x;
	private double y;
	private String type;
	private String img_url;
	//private String isfree;
	private Set<Dish> dishs;
	private double total_sell;
	private double total_money;
	
	public Resturant() {

	}

	public double getTotal_money() {
		return total_money;
	}

	public void setTotal_money(double total_money) {
		this.total_money = total_money;
	}

	public double getTotal_sell() {
		return total_sell;
	}

	public void setTotal_sell(double total_sell) {
		this.total_sell = total_sell;
	}

	public String getResturant_id() {
		return resturant_id;
	}

	public void setResturant_id(String resturant_id) {
		this.resturant_id = resturant_id;
	}

	public String getResturant_name() {
		return resturant_name;
	}

	public void setResturant_name(String resturant_name) {
		this.resturant_name = resturant_name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String getDelivery_limit() {
		return delivery_limit;
	}

	public void setDelivery_limit(String delivery_limit) {
		this.delivery_limit = delivery_limit;
	}

	public int getDelivery_time() {
		return delivery_time;
	}

	public void setDelivery_time(int delivery_time) {
		this.delivery_time = delivery_time;
	}



	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}



	public Set<Dish> getDishs() {
		return dishs;
	}

	public void setDishs(Set<Dish> dishs) {
		this.dishs = dishs;
	}

}
