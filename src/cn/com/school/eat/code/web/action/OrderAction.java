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

import com.google.gson.Gson;

import cn.com.school.eat.code.entity.Address;
import cn.com.school.eat.code.entity.Order;
import cn.com.school.eat.code.service.OrderService;

/**
 * @author renlei 
 * @E-mail:renlei0109@yeah.net
 * @version ����ʱ�䣺2014-5-29 ����12:38:00 ��˵��
 */
@Component("orderAction")  
@Scope("prototype")  
public class OrderAction extends BaseAction{
	private OrderService orderService;
	private String user_id;
	private String resturant_id;
	private String order_id;
	private double total_price;
	private List<Map<String , Object>> maps;
	private Map<String, Object> responsejson;
	
	public OrderService getOrderService() {
		return orderService;
	}
	@Resource
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
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
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	public List<Map<String, Object>> getMaps() {
		return maps;
	}
	public void setMaps(List<Map<String, Object>> maps) {
		this.maps = maps;
	}
	public Map<String, Object> getResponsejson() {
		return responsejson;
	}
	public void setResponsejson(Map<String, Object> responsejson) {
		this.responsejson = responsejson;
	}
	
	/**
	 * 
	 * ����user_id��ѯ���ж���
	 * @param user_id
	 * @return
	 * �ɹ�����һ��list
	 * ʧ�ܷ���"failed"
	 */
	private String QueryOrderAction(){
		
		 List<Order> orders;
		 responsejson = new HashMap<String, Object>();
		try {
			orders = orderService.getOrders(user_id);
			Gson gson = new Gson();
			responsejson.put("result", gson.toJson(orders));
			return SUCCESS;
		} catch (Exception e) {
			responsejson.put("result", "failed");
			return SUCCESS;
			
		}
		 
	}
	
	
	/**
	 * ����user_id��ѯ���˵��ջ���ַ
	 * @param user_id
	 * @return
	 * �ɹ�����һ��list
	 * ʧ�ܷ���"failed"
	 */
	private String MakeOrderAction(){
		
		 List<Address> addresses;
		 responsejson = new HashMap<String, Object>();
		try {
			addresses = orderService.getAddressByUser_id(user_id);
			Gson gson = new Gson();
			responsejson.put("result", gson.toJson(addresses));
			return SUCCESS;
		} catch (Exception e) {
			responsejson.put("result", "failed");
			return SUCCESS;
			
		}
		 
	}
	
	
	/**
	 * ����resturant_id��order���в���ò͹ݵ�ǰ
	 * �����ж�������
	 * @param resturant_id
	 * @return
	 * �ɹ����ض�������
	 * ʧ�ܷ���"failed"
	 */
	
	private String SurplusAction(){
		
		 responsejson = new HashMap<String, Object>();
		try {
			int num  =  orderService.getOrderNum(resturant_id);
			Gson gson = new Gson();
			responsejson.put("result", num);
			return SUCCESS;
		} catch (Exception e) {
			responsejson.put("result", "failed");
			return SUCCESS;
			
		}
		 
	}
	
	
	/**
	 * ȷ��֧��MakeSureAction
	 * 
	 * @param user_id
	 * @param resturant_id
	 * @param map 
	 * ��map�д����dish_id��count��ͨ����ֵ��ȡ��
	 * @param totalPrice
	 * @return
	 * �ɹ�����"success"
	 * ʧ�ܷ���"failed"
	 */
	
	private String MakeSureAction(){
		
		 responsejson = new HashMap<String, Object>();
		try {
			Gson gson = new Gson();
			orderService.saveOrder(user_id, resturant_id, maps, total_price);
			responsejson.put("result", "success");
			return SUCCESS;
		} catch (Exception e) {
			responsejson.put("result", "failed");
			return SUCCESS;
			
		}
		 
	}
	
	
	
}