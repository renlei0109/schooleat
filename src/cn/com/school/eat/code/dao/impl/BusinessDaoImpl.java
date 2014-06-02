package cn.com.school.eat.code.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import cn.com.school.eat.code.dao.BusinessDao;
import cn.com.school.eat.code.entity.Address;
import cn.com.school.eat.code.entity.Business;
import cn.com.school.eat.code.entity.Dish;
import cn.com.school.eat.code.entity.Order_Dish;
import cn.com.school.eat.code.entity.Order_Main;
import cn.com.school.eat.code.entity.Resturant;
import cn.com.school.eat.code.entity.User;

@Component("businessDao")
public class BusinessDaoImpl implements BusinessDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;   
	  
    public HibernateTemplate getHibernateTemplate() {  
        return hibernateTemplate;  
    }
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
    	this.hibernateTemplate = hibernateTemplate;
    }
    
	@Override
	@SuppressWarnings("unchecked")
	public Business isLoginSuccess(String business_name, String password) {
		// TODO Auto-generated method stub
		String hql = "from Business where business_name = ? and password = ?";
		List<Business> businesses = hibernateTemplate.find(hql, new Object[]{business_name, password});
		if(null == businesses || businesses.size() != 1)
			return null;
		else
			return businesses.get(0);
	}
	
	@Override
	public boolean changeState(String business_id, String status) {
		// TODO Auto-generated method stub
		String hql = "from Business where business_id = ?";
		Business business = (Business) hibernateTemplate.find(hql, new Object[]{business_id});
		business.setStatus(status);
		hibernateTemplate.update(business);
		hibernateTemplate.flush();
		return true;
	}
	
	@Override
	public void changePassword(String business_id, String newpassword) {
		// TODO Auto-generated method stub
		String hql = "from Business where business_id = ?";
		Business business = (Business) hibernateTemplate.find(hql, new Object[]{business_id});
		business.setPassword(newpassword);
		hibernateTemplate.update(business);
		hibernateTemplate.flush();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getUntreatedOrders(String business_id) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> result = new ArrayList<>();
		String hql = "from Business where business_id = ?";
		Business business = (Business) hibernateTemplate.find(hql, new Object[]{business_id});
		String resturant_id = business.getResturant_id();
		String hql2 = "from Order where resturant_id = ? and status = '0'";
		
		List<Order_Main> orders = hibernateTemplate.find(hql2, new Object[]{resturant_id});
		for(Order_Main order : orders){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("order_id", order.getOrder_id());
			map.put("order_time", order.getOrder_time());
			map.put("totle_price", order.getTotal_price());
			map.put("user_id", order.getUser_id());
			String hql3 = "from User where user_id = ?";
			User user = (User) hibernateTemplate.find(hql3, new Object[]{order.getUser_id()});
			map.put("user_name", user.getUser_name());
			map.put("address", user.getAddresses());
			map.put("mobile", user.getMobile());
			result.add(map);
		}
		return result;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getTreatedOrders(String business_id) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> result = new ArrayList<>();
		String hql = "from Business where business_id = ?";
		Business business = (Business) hibernateTemplate.find(hql, new Object[]{business_id});
		String resturant_id = business.getResturant_id();
		String hql2 = "from Order where resturant_id = ? and status = '1'";
		
		List<Order_Main> orders = hibernateTemplate.find(hql2, new Object[]{resturant_id});
		for(Order_Main order : orders){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("order_id", order.getOrder_id());
			map.put("order_time", order.getOrder_time());
			map.put("totle_price", order.getTotal_price());
			map.put("user_id", order.getUser_id());
			String hql3 = "from User where user_id = ?";
			User user = (User) hibernateTemplate.find(hql3, new Object[]{order.getUser_id()});
			map.put("user_name", user.getUser_name());
			map.put("address", user.getAddresses());
			map.put("mobile", user.getMobile());
			result.add(map);
		}
		return result;
	}
	
	@Override
	public void completeOrder(String order_id) {
		// TODO Auto-generated method stub
		String hql = "from Order where oder_id = ?";
		Order_Main order = (Order_Main) hibernateTemplate.find(hql, new Object[]{order_id});
		order.setStatus("1");
		hibernateTemplate.update(order);
		hibernateTemplate.flush();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getOrderDetail(String order_id) {
		// TODO Auto-generated method stub
		String hql = "from Order_Dish where order_id = ?";
		List<Order_Dish> dishs = hibernateTemplate.find(hql, new Object[]{order_id});
		List<Map<String, Object>> result = new ArrayList<>();
		for(Order_Dish dish : dishs){
			Map<String, Object> dishMap = new HashMap<>();
			String dish_id = dish.getDish_id();
			Integer count = dish.getCount();
			String hql2 = "from Dish where dish_id = ?";
			Dish dish2 = (Dish) hibernateTemplate.find(hql2, new Object[]{dish_id});
			dishMap.put("count", count);
			dishMap.put("dish_name", dish2.getDish_name());
			dishMap.put("price", dish2.getPrice());
			result.add(dishMap);
		}
		
		return result;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Dish> getDishes(String business_id) {
		// TODO Auto-generated method stub
		String hql = "from Business where business_id = ?";
		Business business = (Business) hibernateTemplate.find(hql, new Object[]{business_id});
		String resturant_id = business.getResturant_id();
		String hql2 = "from Dish where resturant_id = ?";
		List<Dish> dishs = hibernateTemplate.find(hql2, new Object[]{resturant_id});
		return dishs;
	}
	
	@Override
	public void deleteDish(String business_id, String dish_id) {
		// TODO Auto-generated method stub
		String hql = "from Dish where dish_id = ?";
		Dish dish = (Dish) hibernateTemplate.find(hql, new Object[]{dish_id});
		hibernateTemplate.delete(dish);
		hibernateTemplate.flush();
	}
	
	@Override
	public Map<String, Object> getDishDetail(String dish_id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void changeDishInfo(String dish_id, String dish_name,
			String img_url, double price, double sale_price) {
		// TODO Auto-generated method stub
		Dish dish = (Dish)hibernateTemplate.find("froM Dish where dish_id=?",new Object[]{dish_id});
		dish.setDish_name(dish_name);
		dish.setPrice(price);
		dish.setSale_price(sale_price);
		dish.setImg_url(img_url);
		hibernateTemplate.update(dish);
		hibernateTemplate.flush();
	}
	@Override
	public Resturant getShopInfo(String business_id) {
		// TODO Auto-generated method stub
		String hql = "from Business where business_id = ?";
		Business business = (Business) hibernateTemplate.find(hql, new Object[]{business_id});
		String resturant_id = business.getResturant_id();
		String hql2 = "from Resturant where resturant_id = ?";
		Resturant resturant = (Resturant) hibernateTemplate.find(hql2, new Object[]{resturant_id});
		return resturant;
	}
	@Override
	public void changeShopBaseInfo(String business_id, String mobile,
			String summary, String advanceTime) {
		// TODO Auto-generated method stub
		String hql = "from Business from business_id = ?";
		Business business = (Business)hibernateTemplate.find(hql,new Object[]{business_id});
		String resturant_id = business.getResturant_id();
		Resturant resturant = (Resturant) hibernateTemplate.find("from Resturant where reaturant_id = ?", new Object[]{resturant_id});
		resturant.setMobile(mobile);
		//resturant.setSummary(summary);
	    //resturant.setAdvanceTime(advanceTime);
		hibernateTemplate.update(resturant);
		hibernateTemplate.flush();
	}
	@Override
	public void changeShopAddressInfo(String business_id, String province,
			String city, String block, String address) {
		// TODO Auto-generated method stub
		Business business = (Business) hibernateTemplate.find("from Business where business_id = ?", new Object[]{business_id});
		String resturant_id = business.getResturant_id();
		Address address2 = (Address)hibernateTemplate.find("from Address where owner_id = ?", new Object[]{resturant_id});
		address2.setProvince(province);
		address2.setCity(city);
		address2.setZone(block);
		address2.setAddress(address);
		hibernateTemplate.update(address2);
		hibernateTemplate.flush();
	}
}
