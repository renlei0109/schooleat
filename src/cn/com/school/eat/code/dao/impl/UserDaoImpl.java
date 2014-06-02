package cn.com.school.eat.code.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.com.school.eat.code.dao.UserDao;
import cn.com.school.eat.code.entity.Collection;
import cn.com.school.eat.code.entity.ShowDishedCollection;
import cn.com.school.eat.code.entity.ShowResturantCollection;
import cn.com.school.eat.code.entity.User;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
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

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	
	@Override
	@SuppressWarnings("unchecked")
	public User isLoginSuccess(String mobile, String password) {
		// TODO Auto-generated method stub
		String hql = "from User where mobile = ? and password = ?";
		List<User> users = hibernateTemplate.find(hql, new Object[]{mobile, password});
		if(null == users || users.size() != 1)
			return null;
		else
			return users.get(0);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public boolean hasMobile(String mobile) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.mobile = ?";
		List<User> users = hibernateTemplate.find(hql, new Object[]{mobile});
		if(users.size() > 0)
			return true;
		else 
			return false;
	}
	
	
	@Override
	@Scope("REQUIRED")
	public void addNewUser(String mobile) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setMobile(mobile);
		//user.setPassword(password);
		hibernateTemplate.save(user);
		hibernateTemplate.flush();
	}
	
	@Override
	public boolean cancleCollect(String user_id, String id, String type) {
		// TODO Auto-generated method stub
		Collection collection = new Collection();
		collection.setId(id);
		collection.setUser_id(user_id);
		collection.setType(Integer.parseInt(type));
		hibernateTemplate.delete(collection);
		hibernateTemplate.flush();
		return true;
	}
	
	@Override
	public boolean addCollect(String user_id, String id, String type) {
		// TODO Auto-generated method stub
		Collection collection = new Collection();
		collection.setId(id);
		collection.setUser_id(user_id);
		collection.setType(Integer.valueOf(type));
		hibernateTemplate.save(collection);
		hibernateTemplate.flush();
		return true;
	}
	
	@Override
	public List<ShowDishedCollection> showDishedCollection(String user_id) {
		String hql = "select d.dish_name,d.img_url,r.resturant_name,d.price,d.dish_id,d.resturant_id "
				+ "from Collection c,Dish d,Resturant r where c.id=d.dish_id and d.resturant_id=r.resturant_id and  c.user_id =:user_id and c.type = 1";
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<?> list = session.createSQLQuery(hql)
				.setString("user_id", user_id).list();
		transaction.commit();
		ShowDishedCollection sdc = new ShowDishedCollection();
		@SuppressWarnings("rawtypes")
		List enlist = new Vector();
		enlist = list;
		List<ShowDishedCollection> result = new ArrayList<ShowDishedCollection>();
		for (Object obj : enlist) {
			Object[] res = (Object[]) obj;
			sdc.setDish_name(res[0].toString());
			sdc.setImg_url(res[1].toString());
			sdc.setResturant_name(res[2].toString());
			sdc.setPrice(res[3].toString());
			sdc.setDish_id(res[4].toString());
			sdc.setResturant_id(res[5].toString());
			System.out.println(sdc.getImg_url());
			result.add(sdc);
		}
		return result;
	}

	@Override
	public List<ShowResturantCollection> showResturantCollection(String user_id) {
		// TODO Auto-generated method stub
		String hql = "select r.resturant_name,r.resturant_id,r.img_url,r.beginmoney,r.total_sell "
				+ "from Collection c,Resturant r where c.id=r.resturant_id and  c.user_id =:user_id and c.type = 0";
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<?> list = session.createSQLQuery(hql)
				.setString("user_id", user_id).list();
		transaction.commit();
		ShowResturantCollection src = new ShowResturantCollection();
		@SuppressWarnings("rawtypes")
		List enlist = new Vector();
		enlist = list;
		List<ShowResturantCollection> result = new ArrayList<ShowResturantCollection>();
		for (Object obj : enlist) {
			Object[] res = (Object[]) obj;
			src.setResturant_name(res[0].toString());
			src.setResturant_id(res[1].toString());
			src.setImg_url(res[2].toString());
			src.setBeginmoney(res[3].toString());
			src.setTotal_sell(res[4].toString());
			result.add(src);
		}
		return result;

	}

	@Override
	public boolean dishBinding(String user_id, String dish_id) {
		// TODO Auto-generated method stub
		String hql = "from User where user_id = ?";
		User user = (User) hibernateTemplate
				.find(hql, new Object[] { user_id }).get(0);
		user.setBinding(dish_id);
		hibernateTemplate.update(user);
		hibernateTemplate.flush();
		return true;
	}

	@Override
	public void changePassword(String user_id, String oldpassword,
			String newpassword) {
		// TODO Auto-generated method stub
		String hql = "from User where user_id = ?";
		User user = (User) hibernateTemplate.find(hql, new Object[]{user_id}).get(0);
		user.setPassword(newpassword);
		hibernateTemplate.update(user);
		hibernateTemplate.flush();
	}
}
