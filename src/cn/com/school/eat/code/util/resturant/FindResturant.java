
package cn.com.school.eat.code.util.resturant;

import java.util.List;

import cn.com.school.eat.code.entity.Resturant;

/**
 * @author renlei 
 * @E-mail:renlei0109@yeah.net
 * @version ����ʱ�䣺2014-5-31 ����2:06:41 ��˵��
 * ���ݾ�γ�Ȳ��Ҳ����Ľӿ�
 */
public interface FindResturant{
	/**
	 * ���ݾ�γ�ȼ�������̼�һ����Χ�ڵ��̼�
	 * @param longitude  ����
	 * @param latitude   γ��
	 * @return
	 */
	public List<Resturant> findResturants(double longitude,double latitude);
}
