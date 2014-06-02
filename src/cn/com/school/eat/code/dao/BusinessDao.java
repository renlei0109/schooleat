	package cn.com.school.eat.code.dao;

import java.util.List;
import java.util.Map;

import cn.com.school.eat.code.entity.Business;
import cn.com.school.eat.code.entity.Dish;
import cn.com.school.eat.code.entity.Resturant;

public interface BusinessDao {

	public Business isLoginSuccess(String business_name, String password);

	public boolean changeState(String business_id, String status);

	public void changePassword(String business_id, String newpassword);

	public List<Map<String, Object>> getUntreatedOrders(String business_id);

	public List<Map<String, Object>> getTreatedOrders(String business_id);

	public void completeOrder(String order_id);

	public List<Map<String, Object>> getOrderDetail(String order_id);

	public List<Dish> getDishes(String business_id);

	public void deleteDish(String business_id, String dish_id);

	public Map<String, Object> getDishDetail(String dish_id);

	public void changeDishInfo(String dish_id, String dish_name,
			String img_url, double price, double sale_price);

	public Resturant getShopInfo(String business_id);

	public void changeShopBaseInfo(String business_id, String mobile,
			String summary, String advanceTime);

	public void changeShopAddressInfo(String business_id, String province,
			String city, String block, String address);

}
