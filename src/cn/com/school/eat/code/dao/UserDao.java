package cn.com.school.eat.code.dao;

import java.util.List;

import cn.com.school.eat.code.entity.User;

public interface UserDao {

	public User isLoginSuccess(String mobile, String password);

	public boolean hasMobile(String mobile);

	public void addNewUser(String mobile);

	public boolean cancleCollect(String user_id, String id, String type);

	public boolean addCollect(String user_id, String id, String type);

	public List<Object> showDishedCollection(String user_id);

	public List<Object> showResturantCollection(String user_id);

	public boolean dishBinding(String user_id, String dish_id);

	public void changePassword(String user_id, String oldpassword, String newpassword);


}
