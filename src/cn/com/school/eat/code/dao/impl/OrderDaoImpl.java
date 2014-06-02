/**
 * 
 */
package cn.com.school.eat.code.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.com.school.eat.code.dao.OrderDao;
import cn.com.school.eat.code.entity.Address;
import cn.com.school.eat.code.entity.OrderReturn;
import cn.com.school.eat.code.entity.Order_Dish;
import cn.com.school.eat.code.entity.Order_Main;

/**
 * @author renlei 
 * @E-mail:renlei0109@yeah.net
 * @version 创建时间：2014-5-29 上午1:24:13 简单说明
 */
@Component("orderDao")
public class OrderDaoImpl implements OrderDao{
	private HibernateTemplate hibernateTemplate;
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
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
	@SuppressWarnings("deprecation")
	@Override
	public List<OrderReturn> findOrders(String user_id) {
		String hql = "select o.order_id,o.order_time,o.user_id, o.total_price,d.dish_id,d.dish_name,d.img_url,r.resturant_name from order_main o ,order_dish od,dish d,resturant r where o.order_id=od.order_id and od.dish_id=d.dish_id and d.resturant_id = r.resturant_id and user_id=:user_id ";
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<?> list = session.createSQLQuery(hql)
				.setString("user_id", user_id).list();
		transaction.commit();

		@SuppressWarnings("rawtypes")
		List enlist = new Vector();
		enlist = list;
		List<OrderReturn> result = new ArrayList<OrderReturn>();

		for (Object obj : enlist) {
			OrderReturn or = new OrderReturn();
			Map<String, String> map = new HashMap<>();
			Object[] res = (Object[]) obj;
			or.setOrder_id(res[0].toString());
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date = null;
			try {

				date = format.parse(res[1].toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			or.setOrder_time(date);
			or.setUser_id(res[2].toString());
			or.setTotal_price(res[3].toString());
			List<Map<String, String>> list2 = new ArrayList<>();
			for (int i = 0; i < res.length; i++) {
				map.put("dish_id", res[4].toString());
				map.put("dish_name", res[5].toString());
				map.put("img_url", res[6].toString());
				map.put("resturant_name", res[7].toString());
				list2.add(map);
			}
			or.setList(list2);
			result.add(or);
		}
		return result;

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
			Order_Main order = new Order_Main();
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
