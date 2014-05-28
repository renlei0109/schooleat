package cn.com.school.eat.code.entity;

import java.util.Date;
import java.util.Set;

public class Order {

	private String order_id;
	private Date order_time;
	private String user_id;
	private double total_price;
	private String status;

	private Set<Order_Dish> order_Dishs;

	public Order() {

	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public Date getOrder_time() {
		return order_time;
	}

	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Order_Dish> getOrder_Dishs() {
		return order_Dishs;
	}

	public void setOrder_Dishs(Set<Order_Dish> order_Dishs) {
		this.order_Dishs = order_Dishs;
	}

}
