package cn.com.school.eat.code.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.com.school.eat.code.dao.UserDao;
import cn.com.school.eat.code.entity.User;
import cn.com.school.eat.code.service.UserService;

@Component("userService")  
  
public class UserServiceImpl implements UserService {  
	
	@Autowired
	private UserDao userDao;  

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User loginJudge(String mobile, String password) {
		// TODO Auto-generated method stub
		return userDao.isLoginSuccess(mobile, password);
	}

	@Override
	public boolean isMobileExist(String mobile) {
		// TODO Auto-generated method stub
		return userDao.hasMobile(mobile);
	}

	@Override
	@Scope("REQUIRED")
	public void register(String mobile) {
		// TODO Auto-generated method stub
		userDao.addNewUser(mobile);
	}

	@Override
	public boolean cancleColl(String user_id, String id, String type) {
		// TODO Auto-generated method stub
		return userDao.cancleCollect(user_id, id, type);
	}

	@Override
	public boolean addColl(String user_id, String id, String type) {
		// TODO Auto-generated method stub
		return userDao.addCollect(user_id, id, type);
	}

	@Override
	public List<Object> getDishesCollection(String user_id) {
		// TODO Auto-generated method stub
		return userDao.showDishedCollection(user_id);
	}

	@Override
	public List<Object> getResturantCollection(String user_id) {
		// TODO Auto-generated method stub
		return userDao.showResturantCollection(user_id);
	}

	@Override
	public boolean dishBinding(String user_id, String dish_id) {
		// TODO Auto-generated method stub
		return userDao.dishBinding(user_id, dish_id);
	}

	@Override
	public void changePassword(String user_id, String oldpassword, String newpassword) {
		// TODO Auto-generated method stub
		userDao.changePassword(user_id, oldpassword, newpassword);
	}  
}