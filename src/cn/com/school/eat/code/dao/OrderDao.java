/**
 * 
 */
package cn.com.school.eat.code.dao;

import java.util.List;
import java.util.Map;

import cn.com.school.eat.code.entity.Address;
import cn.com.school.eat.code.entity.Order;


/**
 * @author renlei 
 * @E-mail:renlei0109@yeah.net
 * @version 创建时间：2014-5-29 上午1:17:08 简单说明
 */
public interface OrderDao {
		/**
		 * 
		 * 根据user_id查询所有订单
		 * @param user_id
		 * @return
		 * 成功返回一个list
		 * 失败返回"failed"
		 */
		public List<Order> findOrders(String user_id);
		
		
		/**
		 * 根据user_id查询该人的收货地址
		 * @param user_id
		 * @return
		 * 成功返回一个list
		 * 失败返回"failed"
		 */
		public List<Address> findAddressByUser_id(String user_id);
		
		
		/**
		 * 根据resturant_id从order表中查出该餐馆当前
		 * 的所有订单数量
		 * @param resturant_id
		 * @return
		 * 成功返回订单数量
		 * 失败返回"failed"
		 */
		public int findOrderNum(String resturant_id);
		
		/**
		 * 确认支付MakeSureAction
		 * 
		 * @param user_id
		 * @param resturant_id
		 * @param map 
		 * 该map中存放有dish_id和count，通过键值对取出
		 * @param totalPrice
		 * @return
		 * 成功返回"success"
		 * 失败返回"failed"
		 */
		public String  saveOrder(String user_id,String resturant_id,List<Map<String, Object>> map,double totalPrice);
		
		/**
		 * 取消订单
		 * 
		 * 
		 * 根据user_id和order_id删除用户订单表
		 * 订单菜品表中的数据
		 * @param user_id
		 * @param order_id
		 * @return
		 * 成功返回"success"
		 * 失败返回"failed"
		 */
		public String deleteOrder(String user_id,String order_id);
		
		
		
		
}
