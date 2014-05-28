package cn.com.school.eat.code.dao;

import cn.com.school.eat.code.entity.User;

public interface UserDao {

	public User isLoginSuccess(String mobile, String password);

	public boolean hasMobile(String mobile);

	public void addNewUser(String mobile, String password);


}
