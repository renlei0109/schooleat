package cn.com.school.eat.code.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.com.school.eat.code.dao.UserDao;
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
		String hql = "from User u where u.mobile = ? and u.password = ?";
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
	public void addNewUser(String mobile, String password) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setMobile(mobile);
		user.setPassword(password);
		hibernateTemplate.save("User", user);
	}
}
