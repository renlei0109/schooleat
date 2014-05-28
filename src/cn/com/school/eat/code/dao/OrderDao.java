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
 * @version ����ʱ�䣺2014-5-29 ����1:17:08 ��˵��
 */
public interface OrderDao {
		/**
		 * 
		 * ����user_id��ѯ���ж���
		 * @param user_id
		 * @return
		 * �ɹ�����һ��list
		 * ʧ�ܷ���"failed"
		 */
		public List<Order> findOrders(String user_id);
		
		
		/**
		 * ����user_id��ѯ���˵��ջ���ַ
		 * @param user_id
		 * @return
		 * �ɹ�����һ��list
		 * ʧ�ܷ���"failed"
		 */
		public List<Address> findAddressByUser_id(String user_id);
		
		
		/**
		 * ����resturant_id��order���в���ò͹ݵ�ǰ
		 * �����ж�������
		 * @param resturant_id
		 * @return
		 * �ɹ����ض�������
		 * ʧ�ܷ���"failed"
		 */
		public int findOrderNum(String resturant_id);
		
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
		public String  saveOrder(String user_id,String resturant_id,List<Map<String, Object>> map,double totalPrice);
		
		/**
		 * ȡ������
		 * 
		 * 
		 * ����user_id��order_idɾ���û�������
		 * ������Ʒ���е�����
		 * @param user_id
		 * @param order_id
		 * @return
		 * �ɹ�����"success"
		 * ʧ�ܷ���"failed"
		 */
		public String deleteOrder(String user_id,String order_id);
		
		
		
		
}
