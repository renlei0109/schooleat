package cn.com.school.eat.code.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;

import cn.com.school.eat.code.entity.ShowDishedCollection;
import cn.com.school.eat.code.entity.ShowResturantCollection;
import cn.com.school.eat.code.entity.User;
import cn.com.school.eat.code.service.UserService;
import cn.com.school.eat.code.util.user.SendMsg_webchinese;
  
@Component("userAction")  
@Scope("prototype")  
public class UserAction extends BaseAction {  
    private static final long serialVersionUID = 1L;  
    private String user_name;
	private String password;
	private String mobile;
	private String captcha;
	private Map<String, Object> responseJson;
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Autowired
	private UserService userService;

	private String myCaptcha;
	private long timeLimit;
	
	private String id;
	private String type;
	private String user_id;
	private String dish_id;
	
	private String oldpassword;
	private String newpassword;

	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getDish_id() {
		return dish_id;
	}
	public void setDish_id(String dish_id) {
		this.dish_id = dish_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(long timeLimit) {
		this.timeLimit = timeLimit;
	}
	public String getMyCaptcha() {
		return myCaptcha;
	}
	public void setMyCaptcha(String myCaptcha) {
		this.myCaptcha = myCaptcha;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Object> getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
    
    public String userLogin() throws Exception {
    	System.out.println(mobile+"***********************");
    	responseJson = new HashMap<>();
    	User user = userService.loginJudge(mobile, password);
    	if(null == user){
    		responseJson.put("result", "failed");
    	}
    	else{
    		Gson gson = new Gson();
    		String result = gson.toJson(user);
    		responseJson.put("result", result);
    	}
		return SUCCESS;
    }
    
    public String registerStep1() throws Exception {
    	responseJson = new HashMap<>();
    	boolean isMobileExist = userService.isMobileExist(mobile);
    	if(true == isMobileExist)
    		responseJson.put("result", "failed");
    	else {
    		//responseJson.put("result", "success");
    		int[] array = {0,1,2,3,4,5,6,7,8,9};
    		Random rand = new Random();
    		for (int i = 10; i > 1; i--) {
    		    int index = rand.nextInt(i);
    		    int tmp = array[index];
    		    array[index] = array[i - 1];
    		    array[i - 1] = tmp;
    		}
    		int result = 0;
    		for(int i = 0; i < 6; i++)
    		    result = result * 10 + array[i];
    		this.myCaptcha = String.valueOf(result);
    		this.timeLimit = new Date().getTime();
    		responseJson.put("result", result);
    		responseJson.put("timeLimit", timeLimit);
    		System.out.println(mobile+"*********************");
    		new SendMsg_webchinese().sendMsg(mobile, result);//将验证码发送到手机
    		System.out.println("******************");
    	}
    	return SUCCESS;
    }
    
    public String registerStep2() throws Exception {
    	responseJson = new HashMap<>();
    	userService.register(mobile);
    	User user = (User) hibernateTemplate.find("from User u where u.mobile = ?",new Object[]{mobile}).get(0);
    	responseJson.put("result", "success");
    	responseJson.put("user_id", user.getUser_id());
    	return SUCCESS;
    }
    
    public String cancleCollect() throws Exception {
		responseJson = new HashMap<>();
		boolean result = userService.cancleColl(user_id, id, type);
		if (result == true)
			responseJson.put("result", "success");
		else
			responseJson.put("result", "failed");
		return SUCCESS;
	}
    
    public String addCollect() throws Exception {
    	responseJson = new HashMap<>();
    	boolean result = userService.addColl(user_id, id, type);
    	if(result == true)
    		responseJson.put("result", "success");
    	else
    		responseJson.put("result", "failed");
    	return SUCCESS;
    }
    public String showCollect() throws Exception {
		responseJson = new HashMap<>();
		List<ShowDishedCollection> list = null;
		List<ShowResturantCollection> list2 = null;
		if (type.equals("1")) {
			list = userService.getDishesCollection(user_id);
			Gson gson = new Gson();
			String result = gson.toJson(list);
			responseJson.put("result", result);
			return SUCCESS;
		} else {
			list2 = userService.getResturantCollection(user_id);
			Gson gson = new Gson();
			String result = gson.toJson(list2);
			responseJson.put("result", result);
			return SUCCESS;
		}

	}

	public String dishBinding() throws Exception {
		responseJson = new HashMap<>();
		boolean result = userService.dishBinding(user_id, dish_id);
		if (result == true)
			responseJson.put("result", "success");
		else
			responseJson.put("result", "failed");
		return SUCCESS;
	}
    public String passwordChange() throws Exception {
    	responseJson = new HashMap<>();
    	userService.changePassword(user_id, oldpassword, newpassword);
    	return SUCCESS;
    }
}  