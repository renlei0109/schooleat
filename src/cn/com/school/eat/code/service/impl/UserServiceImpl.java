package cn.com.school.eat.code.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
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
	public void register(String mobile, String password) {
		// TODO Auto-generated method stub
		userDao.addNewUser(mobile, password);
	}
      
}