/**
 * 
 */
package cn.com.school.eat.code.web.action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import cn.com.school.eat.code.entity.Collection;
import cn.com.school.eat.code.entity.Dish;
import cn.com.school.eat.code.entity.Resturant;
import cn.com.school.eat.code.service.ResturantService;
import cn.com.school.eat.code.util.resturant.ResturantUtil;

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
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	public String getResturantByNormal(){
		
		//System.out.println("*******"+longitude+"****"+latitude+"*****");
		resturants = resturantService.getResturantByNormal(longitude, latitude);
		distances = new ResturantUtil().getDistance(longitude, latitude, resturants);
		responseJson = new HashMap<String, Object>();
		System.out.println(resturants.get(0).toString()+"****************");
		System.out.println(distances.get(0).toString());
		if(resturants!=null){
			responseJson.put("result", gson.toJson(resturants));
			responseJson.put("distance", gson.toJson(distances));
			return SUCCESS;
		}
		responseJson.put("result", "failed");
		return SUCCESS;
		
	}
	
	
	public String getResturantByMonthSell(){
		resturants = resturantService.getResturantByMonthSell(longitude, latitude);
		distances = new ResturantUtil().getDistance(longitude, latitude, resturants);
		responseJson = new HashMap<String, Object>();
		if(resturants!=null){
			responseJson.put("result", gson.toJson(resturants));
			responseJson.put("distance", gson.toJson(distances));
			return SUCCESS;
		}
		responseJson.put("result", "failed");
		return SUCCESS;
		
	}
	
	
	public String getResturantByMoney(){
		resturants = resturantService.getResturantByMoney(longitude, latitude);
		distances = new ResturantUtil().getDistance(longitude, latitude, resturants);
		responseJson = new HashMap<String, Object>();
		if(resturants!=null){
			responseJson.put("result", gson.toJson(resturants));
			responseJson.put("distance", distances);
			return SUCCESS;
		}
		responseJson.put("result", "failed");
		return SUCCESS;
	}
	
	
	public String getResturantByDistance(){
		resturants = resturantService.getResturantByDistance(longitude, latitude);
		distances = new ResturantUtil().getDistance(longitude, latitude, resturants);
		responseJson = new HashMap<String, Object>();
		if(resturants!=null){
			responseJson.put("result", gson.toJson(resturants));
			responseJson.put("distance", distances);
			return SUCCESS;
		}
		responseJson.put("result", "failed");
		return SUCCESS;
	}
	
	public String getResturantByBeginMoney(){
		resturants = resturantService.getResturantByMoney(longitude, latitude);
		distances = new ResturantUtil().getDistance(longitude, latitude, resturants);
		responseJson = new HashMap<String, Object>();
			if(resturants!=null){
				
				responseJson.put("result", gson.toJson(resturants));
				responseJson.put("distance",distances);
					return SUCCESS;
			}
			responseJson.put("result", "failed");
				return SUCCESS;
	}
	
	public String collectResturant(){
		Collection collection = new Collection();
		collection.setUser_id(user_id);
		collection.setId(resturant_id);
		collection.setType(0);
		hibernateTemplate.save(collection);
		hibernateTemplate.flush();
		responseJson.put("result", "success");
		return SUCCESS;
	}
	
	

	
	

	private ResturantService resturantService;
	private double longitude;
	private double latitude;
	private Map<String, Object>responseJson;
	private List<Resturant>resturants = null;
	public  Gson gson = new Gson();
	private List<Double>distances = new ArrayList<Double>();
	private String user_id;
	private String resturant_id;
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getResturant_id() {
		return resturant_id;
	}

	public void setResturant_id(String resturant_id) {
		this.resturant_id = resturant_id;
	}

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
