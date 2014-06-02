package cn.com.school.eat.code.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.com.school.eat.code.dao.UserDao;
import cn.com.school.eat.code.entity.Collection;
import cn.com.school.eat.code.entity.User;

@Repository
public class UserDaoImpl implements UserDao{
	
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
		collection.setType(Integer.valueOf(type));
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
	@SuppressWarnings("unchecked")
	public List<Object> showDishedCollection(String user_id) {
		// TODO Auto-generated method stub
		String hql = "from Collection where user_id = ? and type = 1";
		List<Object> dishs = hibernateTemplate.find(hql, new Object[]{user_id});
		return dishs;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Object> showResturantCollection(String user_id) {
		// TODO Auto-generated method stub
		String hql = "from Collection where user_id = ? and type = 2";
		List<Object> resturants = hibernateTemplate.find(hql, new Object[]{user_id});
		return resturants;
	}
	@Override
	public boolean dishBinding(String user_id, String dish_id) {
		// TODO Auto-generated method stub
		String hql = "from User where user_id = ?";
		User user = (User) hibernateTemplate.find(hql, new Object[]{user_id}).get(0);
		if(null == user.getBinding() || "".equals(user.getBinding())){
			user.setBinding(dish_id);
			hibernateTemplate.update(user);
			hibernateTemplate.flush();
			return true;
		}
		else {
			return false;
		}
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
