package cn.com.school.eat.code.service;

import java.util.List;

import cn.com.school.eat.code.entity.ShowDishedCollection;
import cn.com.school.eat.code.entity.ShowResturantCollection;
import cn.com.school.eat.code.entity.User;


public interface UserService {

	public User loginJudge(String mobile, String password);

	public boolean isMobileExist(String mobile);

	public void register(String mobile);

	public boolean cancleColl(String user_id, String id, String type);

	public boolean addColl(String user_id, String id, String type);

	public List<ShowDishedCollection> getDishesCollection(String user_id);

	public List<ShowResturantCollection> getResturantCollection(String user_id);

	public boolean dishBinding(String user_id, String dish_id);

	public void changePassword(String user_id, String oldpassword, String newpassword);  

  
}  