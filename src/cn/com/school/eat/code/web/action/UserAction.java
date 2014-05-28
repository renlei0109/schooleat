package cn.com.school.eat.code.web.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import cn.com.school.eat.code.entity.User;
import cn.com.school.eat.code.service.UserService;
  
@Component("userAction")  
@Scope("prototype")  
public class UserAction extends BaseAction {  
  
    private static final long serialVersionUID = 1L;  
  
    private String user_name;
	private String password;
	private String mobile;
	private String captcha;
	private Map<String, Object> responseJson;
	
	@Autowired
	private UserService userService;

	private String myCaptcha;
	private long timeLimit;
	public String getMyCaptcha() {
		return myCaptcha;
	}
	public void setMyCaptcha(String myCaptcha) {
		this.myCaptcha = myCaptcha;
	}

	public long getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(long timeLimit) {
		this.timeLimit = timeLimit;
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
    	responseJson = new HashMap<>();
    	User user = userService.loginJudge(mobile, password);
    	if(null == user){
    		responseJson.put("User", "failed");
    	}
    	else{
    		Gson gson = new Gson();
    		String result = gson.toJson(user, User.class);
    		responseJson.put("User", result);
    	}
		return SUCCESS;
    }
    
    public String registerStep1() throws Exception {
    	responseJson = new HashMap<>();
    	boolean isMobileExist = userService.isMobileExist(mobile);
    	if(true == isMobileExist)
    		responseJson.put("result", "fail");
    	else {
    		responseJson.put("result", "success");
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
    	}
    	return SUCCESS;
    }
    
    public String registerStep2() throws Exception {
    	responseJson = new HashMap<>();
    	long now = new Date().getTime();
    	if(now - timeLimit > 1000*60*3) {
    		responseJson.put("result", false);
    		myCaptcha = new String();
    		timeLimit = 0;
    	}
    	else if(captcha != myCaptcha)
    		responseJson.put("result", false);
    	else {
    		userService.register(mobile, password);
    		responseJson.put("result", "success");
    	}
    	return SUCCESS;
    }
}  