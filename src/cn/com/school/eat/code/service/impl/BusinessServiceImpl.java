package cn.com.school.eat.code.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.school.eat.code.dao.BusinessDao;
import cn.com.school.eat.code.entity.Business;
import cn.com.school.eat.code.entity.Dish;
import cn.com.school.eat.code.entity.Resturant;
import cn.com.school.eat.code.service.BusinessService;

@Component("businessService")
public class BusinessServiceImpl implements BusinessService{

	@Autowired
	BusinessDao businessDao;
	
	public BusinessDao getBusinessDao() {
		return businessDao;
	}

	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}

	@Override
	public Business loginJudge(String business_name, String password) {
		// TODO Auto-generated method stub
		return businessDao.isLoginSuccess(business_name,password);
	}

	@Override
	public boolean changeState(String business_id, String status) {
		// TODO Auto-generated method stub
		return businessDao.changeState(business_id, status);
	}

	@Override
	public void changePassword(String business_id, String newpassword) {
		// TODO Auto-generated method stub
		businessDao.changePassword(business_id, newpassword);
	}

	@Override
	public List<Map<String, Object>> getUntreatedOrders(String business_id) {
		// TODO Auto-generated method stub
		return businessDao.getUntreatedOrders(business_id);
	}

	@Override
	public List<Map<String, Object>> getTreatedOrders(String business_id) {
		// TODO Auto-generated method stub
		return businessDao.getTreatedOrders(business_id);
	}

	@Override
	public void completeOrder(String order_id) {
		// TODO Auto-generated method stub
		businessDao.completeOrder(order_id);
	}

	@Override
	public List<Map<String, Object>> getOrderDetail(String order_id) {
		// TODO Auto-generated method stub
		return businessDao.getOrderDetail(order_id);
	}

	@Override
	public List<Dish> getDishes(String business_id) {
		// TODO Auto-generated method stub
		return businessDao.getDishes(business_id);
	}

	@Override
	public void deleteDish(String business_id, String dish_id) {
		// TODO Auto-generated method stub
		businessDao.deleteDish(business_id,dish_id);
	}

	@Override
	public Map<String, Object> getDishDetail(String dish_id) {
		// TODO Auto-generated method stub
		return businessDao.getDishDetail(dish_id);
	}

	@Override
	public void changeDishInfo(String dish_id, String dish_name,
			String img_url, double price, double sale_price) {
		// TODO Auto-generated method stub
		businessDao.changeDishInfo(dish_id,dish_name,img_url,price,sale_price);
	}

	@Override
	public Resturant getShopInfo(String business_id) {
		// TODO Auto-generated method stub
		return businessDao.getShopInfo(business_id);
	}

	@Override
	public void changeShopBaseInfo(String business_id, String mobile,
			String summary, String advanceTime) {
		// TODO Auto-generated method stub
		businessDao.changeShopBaseInfo(business_id,mobile,summary,advanceTime);
	}

	@Override
	public void changeShopAddressInfo(String business_id, String province,
			String city, String block, String address) {
		// TODO Auto-generated method stub
		businessDao.changeShopAddressInfo(business_id, province, city, block, address);
	}

}
