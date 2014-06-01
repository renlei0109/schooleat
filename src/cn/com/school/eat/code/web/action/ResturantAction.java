/**
 * 
 */
package cn.com.school.eat.code.web.action;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.com.school.eat.code.entity.Resturant;
import cn.com.school.eat.code.service.ResturantService;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author renlei 
 * @E-mail:renlei0109@yeah.net
 * @version 创建时间：2014-5-31 下午6:22:27 简单说明
 */
@Component("resturantAction")
@Scope("prototype")
public class ResturantAction extends ActionSupport{
	
	public String getResturantByNormal(){
		
		System.out.println("*******"+longitude+"****"+latitude+"*****");
		resturants = resturantService.getResturantByNormal(longitude, latitude);
		System.out.println(resturants.get(0).toString()+"&&&&&&&&&&&&&&&&&&&&&&&");
		responseJson = new HashMap<String, Object>();
		if(resturants!=null){
			responseJson.put("result", gson.toJson(resturants));
			return SUCCESS;
		}
		responseJson.put("result", "failed");
		return SUCCESS;
		
	}
	
	
	public String getResturantByMonthSell(){
		resturants = resturantService.getResturantByMonthSell(longitude, latitude);
		if(resturants!=null){
			responseJson.put("result", gson.toJson(resturants));
			return SUCCESS;
		}
		responseJson.put("result", "failed");
		return SUCCESS;
		
	}
	
	
	public String getResturantByMoney(){
		resturants = resturantService.getResturantByMoney(longitude, latitude);
		if(resturants!=null){
			responseJson.put("result", gson.toJson(resturants));
			return SUCCESS;
		}
		responseJson.put("result", "failed");
		return SUCCESS;
		
	}
	
	
	public String getResturantByDistance(){
		resturants = resturantService.getResturantByDistance(longitude, latitude);
		if(resturants!=null){
			responseJson.put("result", gson.toJson(resturants));
			return SUCCESS;
		}
		responseJson.put("result", "failed");
		return SUCCESS;
		
	}
	
	
	
	
	
	
	
	
	private ResturantService resturantService;
	private double longitude;
	private double latitude;
	private Map<String, Object>responseJson;
	private List<Resturant>resturants = null;
	public  Gson gson = new Gson();
	public ResturantService getResturantService() {
		return resturantService;
	}
	@Resource
	public void setResturantService(ResturantService resturantService) {
		this.resturantService = resturantService;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public Map<String, Object> getResponseJson() {
		return responseJson;
	}
	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}
	
}
