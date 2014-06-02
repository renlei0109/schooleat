package cn.com.school.eat.code.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import cn.com.school.eat.code.entity.Business;
import cn.com.school.eat.code.entity.Dish;
import cn.com.school.eat.code.entity.Resturant;
import cn.com.school.eat.code.service.BusinessService;

@Component("businessAction")  
@Scope("prototype")  
public class BusinessAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String business_id;
	private String business_name;
	private String password;
	private String status;
	private String resturant_id;
	private String newpassword;
	private String order_id;
	private String dish_id;
	private String dish_name;
	private double price;
	private double sale_price;
	private String img_url;
	private String mobile;
	private String summary;
	private String advanceTime;
	private String province;
	private String city;
	private String block;
	private String address;
	
	
	
	private Map<String, Object> responseJson;
	private BusinessService businessService;
	
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getAdvanceTime() {
		return advanceTime;
	}
	public void setAdvanceTime(String advanceTime) {
		this.advanceTime = advanceTime;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDish_name() {
		return dish_name;
	}
	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSale_price() {
		return sale_price;
	}
	public void setSale_price(double sale_price) {
		this.sale_price = sale_price;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getDish_id() {
		return dish_id;
	}
	public void setDish_id(String dish_id) {
		this.dish_id = dish_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResturant_id() {
		return resturant_id;
	}
	public void setResturant_id(String resturant_id) {
		this.resturant_id = resturant_id;
	}
	public BusinessService getBusinessService() {
		return businessService;
	}
	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}
	public Map<String, Object> getResponseJson() {
		return responseJson;
	}
	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}
	public String getBusiness_id() {
		return business_id;
	}
	public void setBusiness_id(String business_id) {
		this.business_id = business_id;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String shopkeeperLogin(){
		System.out.println("I am here");
		responseJson = new HashMap<String, Object>();
		Business business = businessService.loginJudge(business_name,password);
		Gson gson = new Gson();
		if(null == business)
			responseJson.put("result", "failed");
		else{
			String result = gson.toJson(business);
		    responseJson.put("result", result);
		}
		return SUCCESS;
	}
	
	public String changeState(){
		responseJson =new HashMap<>();
		businessService.changeState(business_id, status);
		responseJson.put("result", "success");
		return SUCCESS;
	}
	
	public String shopkeeperChangePassword() {
		responseJson = new HashMap<>();
		businessService.changePassword(business_id, newpassword);
		responseJson.put("result", "success");
		return SUCCESS;
	}
	
	public String getUntreatedOrders() {
		responseJson = new HashMap<>();
		List<Map<String, Object>> orders = businessService.getUntreatedOrders(business_id);
		Gson gson = new Gson();
		String result = gson.toJson(orders);
		responseJson.put("result", result);
		return SUCCESS;
	}
	
	public String getTreatedOrders() {
		responseJson = new HashMap<>();
		List<Map<String, Object>> orders = businessService.getTreatedOrders(business_id);
		Gson gson = new Gson();
		String result = gson.toJson(orders);
		responseJson.put("result", result);
		return SUCCESS;
	}
	
	public String completeOrder() {
		responseJson = new HashMap<>();
		businessService.completeOrder(order_id);
		responseJson.put("result", "success");
		return SUCCESS;
	}
	
	public String getOrderDetail() {
		responseJson = new HashMap<>();
		List<Map<String, Object>> list = businessService.getOrderDetail(order_id);
		Gson gson = new Gson();
		gson.toJson(list);
		return SUCCESS;
	}
	
	public String getDishes(){
		responseJson = new HashMap<>();
		List<Dish> dishs = businessService.getDishes(business_id);
		Gson gson = new Gson();
		String result = gson.toJson(dishs);
		responseJson.put("result", result);
		return SUCCESS;
	}
	
	public String deleteDish(){
		responseJson = new HashMap<>();
		businessService.deleteDish(business_id, dish_id);
		responseJson.put("result", "success");
		return SUCCESS;
	}
	
	public String getDishDetail(){
		responseJson = new HashMap<>();
		Gson gson = new Gson();
		Map<String, Object> map = businessService.getDishDetail(dish_id);
		String result = gson.toJson(map);
		responseJson.put("result", result);
		return SUCCESS;
	}
	
	public String changeDishInfo(){
		responseJson = new HashMap<>();
		businessService.changeDishInfo(dish_id,dish_name,img_url,price,sale_price);
		return SUCCESS;
	}
	
	public String getShopInfo(){
		responseJson = new HashMap<>();
		Resturant resturant = businessService.getShopInfo(business_id);
		Gson gson = new Gson();
		String result = gson.toJson(resturant);
		responseJson.put("result", result);
		return SUCCESS;
	}
	
	public String changeShopBaseInfo(){
		responseJson = new HashMap<>();
		businessService.changeShopBaseInfo(business_id,mobile,summary,advanceTime);
		responseJson.put("result", "success");
		return SUCCESS;
	}
	
	public String changeShopAddressInfo(){
		responseJson = new HashMap<>();
		businessService.changeShopAddressInfo(business_id, province, city, block, address);
		responseJson.put("result", "success");
		return SUCCESS;
	}
	
	public String changeShopBusinessTime() {
		responseJson = new HashMap<>();
		responseJson.put("result", "success");
		return SUCCESS;
	}
	
}
