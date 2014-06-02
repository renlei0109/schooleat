package cn.com.school.eat.code.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.school.eat.code.entity.*;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import cn.com.school.eat.code.entity.Dish;
import cn.com.school.eat.code.entity.Dish_Rec;
import cn.com.school.eat.code.service.OtherService;

@Component("OtherAction")
@Scope("prototype")
public class OtherAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> responseJson;
	private String receiveJson;
	private String user_id;
	private String owner_id;
	private String address_id;
	private String content;
	private String page;

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	private OtherService otherService;

	public Map<String, Object> getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}

	public String getReceiveJson() {
		return receiveJson;
	}

	public void setReceiveJson(String receiveJson) {
		this.receiveJson = receiveJson;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}

	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public OtherService getOtherService() {
		return otherService;
	}

	@Resource
	public void setOtherService(OtherService otherService) {
		this.otherService = otherService;
	}

	public String ShakeAction() throws Exception {
		responseJson = new HashMap<String, Object>();
		Dish dish = null;
		try {
			dish = otherService.Shake();
		} catch (Exception e) {
			responseJson.put("result", "failed");
			e.printStackTrace();
			return SUCCESS;
		}
		Gson gson = new Gson();
		String result = gson.toJson(dish, Dish.class);
		System.out.println(result);
		responseJson.put("result", result);
		return SUCCESS;
	}

	public String Home_IMGAction() throws Exception {
		int i = (int) Integer.parseInt(page);
		responseJson = new HashMap<String, Object>();
		List<Dish_Rec> list = null;
		try {
			list = otherService.Home_IMG(i);
		} catch (Exception e) {
			responseJson.put("result", "failed");
			e.printStackTrace();
			return SUCCESS;
		}
		Gson gson = new Gson();
		String result = gson.toJson(list);
		System.out.println(result);
		responseJson.put("result", result);
		return SUCCESS;
	}

	public String ZhaiAction() throws Exception {
		responseJson = new HashMap<String, Object>();
		Dish dish = null;
		try {
			dish = otherService.Zhai(user_id);
		} catch (Exception e) {
			responseJson.put("result", "failed");
			e.printStackTrace();
			return SUCCESS;
		}
		Gson gson = new Gson();
		String result = gson.toJson(dish, Dish.class);
		System.out.println(result);
		responseJson.put("result", result);
		return SUCCESS;
	}

	public String QueryAddressAction() throws Exception {
		responseJson = new HashMap<String, Object>();
		List<Address> list = null;
		try {
			list = otherService.QueryAddress(owner_id);
		} catch (Exception e) {
			responseJson.put("result", "failed");
			e.printStackTrace();
			return SUCCESS;
		}
		Gson gson = new Gson();
		String result = gson.toJson(list);
		System.out.println(result);
		responseJson.put("result", result);
		return SUCCESS;
	}

	public String AddAddressAction() throws Exception {
		responseJson = new HashMap<String, Object>();
		Gson gson1 = new Gson();
		Address address = gson1.fromJson(receiveJson, Address.class);
		String string = null;
		try {
			string = otherService.AddAddress(address);
		} catch (Exception e) {
			responseJson.put("result", "failed");
			e.printStackTrace();
			return SUCCESS;
		}
		Gson gson2 = new Gson();
		String result = gson2.toJson(string);
		System.out.println(result);
		responseJson.put("result", result);
		return SUCCESS;
	}

	public String ChangeAddressAction() throws Exception {
		responseJson = new HashMap<String, Object>();
		Gson gson1 = new Gson();
		Address address = gson1.fromJson(receiveJson, Address.class);
		String string = null;
		try {
			string = otherService.ChangeAddress(address);
		} catch (Exception e) {
			responseJson.put("result", "failed");
			e.printStackTrace();
			return SUCCESS;
		}
		Gson gson2 = new Gson();
		String result = gson2.toJson(string);
		System.out.println(result);
		responseJson.put("result", result);
		return SUCCESS;
	}

	public String DeleteAddressAction() throws Exception {
		responseJson = new HashMap<String, Object>();
		String string = null;
		try {
			string = otherService.DeleteAddress(user_id, owner_id);
		} catch (Exception e) {
			responseJson.put("result", "failed");
			e.printStackTrace();
			return SUCCESS;
		}
		Gson gson2 = new Gson();
		String result = gson2.toJson(string);
		System.out.println(result);
		responseJson.put("result", result);
		return SUCCESS;
	}

	public String AdviceAction() throws Exception {
		responseJson = new HashMap<String, Object>();
		String string = null;
		try {
			string = otherService.Suggest(user_id, content);
		} catch (Exception e) {
			responseJson.put("result", "failed");
			e.printStackTrace();
			return SUCCESS;
		}
		Gson gson2 = new Gson();
		String result = gson2.toJson(string);
		System.out.println(result);
		responseJson.put("result", result);
		return SUCCESS;
	}

}
