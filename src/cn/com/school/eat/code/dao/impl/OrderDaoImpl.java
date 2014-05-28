/**
 * 
 */
package cn.com.school.eat.code.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.com.school.eat.code.dao.OrderDao;
import cn.com.school.eat.code.entity.Address;
import cn.com.school.eat.code.entity.Order;
import cn.com.school.eat.code.entity.Order_Dish;

/**
 * @author renlei 
 * @E-mail:renlei0109@yeah.net
 * @version 创建时间：2014-5-29 上午1:24:13 简单说明
 */
@Component("orderDao")
public class OrderDaoImpl implements OrderDao{
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/* (non-Javadoc)
	 * @see cn.com.school.eat.code.dao.OrderDao#findOrders(java.lang.String)
	 */
	@Override
	public List<Order> findOrders(String user_id) {
		String hql = "from Order o where o.user_id = ?";
		List<Order>orders = hibernateTemplate.find(hql,new Object[]{user_id});
		if(null==orders){
			return null;
		}
		return orders;
	}

	/* (non-Javadoc)
	 * @see cn.com.school.eat.code.dao.OrderDao#findAddressByUser_id(java.lang.String)
	 */
	@Override
	public List<Address> findAddressByUser_id(String user_id) {
		String hql ="from Address a where a.owner_id = ?";
		List<Address>addresses = hibernateTemplate.find(hql,new Object[]{user_id});
		if(null == addresses){
			return null;
		}
		
		return addresses;
	}

	/* (non-Javadoc)
	 * @see cn.com.school.eat.code.dao.OrderDao#findOrderNum(java.lang.String)
	 */
	@Override
	public int findOrderNum(String resturant_id) {
		String hql = "select sum(count) from Order_Dish rd where rd.resturant_id=?";
		List list = hibernateTemplate.find(hql,new Object[]{resturant_id});
		if(list == null||list.size()==0){
			return 0;
			
		}
		return (Integer)list.get(0);
	}

	/* (non-Javadoc)
	 * @see cn.com.school.eat.code.dao.OrderDao#saveOrder(java.lang.String, java.lang.String, java.util.List, double)
	 */
	@Override
	public String saveOrder(String user_id, String resturant_id,
			List<Map<String, Object>> maps, double total_price) {
			Order order = new Order();
			order.setUser_id(user_id);
			order.setResturant_id(resturant_id);
			order.setTotal_price(total_price);
			Set<Order_Dish>order_Dishs = new HashSet<Order_Dish>();
			
			for(Map<String, Object> map :maps) {
				Order_Dish order_Dish = new Order_Dish();
				order_Dish.setDish_id(map.get("dish_id").toString());
				order_Dish.setResturant_id(resturant_id);
				order_Dish.setCount((Integer)map.get("count"));
				order_Dishs.add(order_Dish);
			}
			hibernateTemplate.save(order);
			hibernateTemplate.flush();
			return "success";
	}

	/* (non-Javadoc)
	 * @see cn.com.school.eat.code.dao.OrderDao#deleteOrder(java.lang.String, java.lang.String)
	 */
	@Override
	public String deleteOrder(String user_id, String order_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
