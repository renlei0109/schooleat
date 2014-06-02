/**
 * 
 */
package cn.com.school.eat.code.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.school.eat.code.dao.OrderDao;
import cn.com.school.eat.code.entity.Address;
import cn.com.school.eat.code.entity.OrderReturn;
import cn.com.school.eat.code.service.OrderService;

/**
 * @author renlei 
 * @E-mail:renlei0109@yeah.net
 * @version 创建时间：2014-5-29 上午2:34:22 简单说明
 */
@Component("orderService")
public class OrderServiceImpl implements OrderService{
	private OrderDao orderDao;
	
	public OrderDao getOrderDao() {
		return orderDao;
	}
	@Resource
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	/* (non-Javadoc)
	 * @see cn.com.school.eat.code.service.OrderService#getOrders(java.lang.String)
	 */
	@Override
	public List<OrderReturn> getOrders(String user_id) {
		
		return orderDao.findOrders(user_id);
	}

	/* (non-Javadoc)
	 * @see cn.com.school.eat.code.service.OrderService#getAddressByUser_id(java.lang.String)
	 */
	@Override
	public List<Address> getAddressByUser_id(String user_id) {
		return orderDao.findAddressByUser_id(user_id);
	}

	/* (non-Javadoc)
	 * @see cn.com.school.eat.code.service.OrderService#getOrderNum(java.lang.String)
	 */
	@Override
	public int getOrderNum(String resturant_id) {
		
		return orderDao.findOrderNum(resturant_id);
	}

	/* (non-Javadoc)
	 * @see cn.com.school.eat.code.service.OrderService#saveOrder(java.lang.String, java.lang.String, java.util.List, double)
	 */
	@Override
	public String saveOrder(String user_id, String resturant_id,
			List<Map<String, Object>> map, double totalPrice) {
		// TODO Auto-generated method stub
		return orderDao.saveOrder(user_id, resturant_id, map, totalPrice);
	}

	/* (non-Javadoc)
	 * @see cn.com.school.eat.code.service.OrderService#deleteOrder(java.lang.String, java.lang.String)
	 */
	@Override
	public String deleteOrder(String user_id, String order_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
