package cn.com.school.eat.code.service;

import cn.com.school.eat.code.entity.User;


public interface UserService {

	public User loginJudge(String mobile, String password);

	public boolean isMobileExist(String mobile);

	public void register(String mobile, String password);  

  
}  