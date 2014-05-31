/**
 * 
 */
package cn.com.school.eat.code.dao;

import java.util.List;

import cn.com.school.eat.code.entity.Resturant;

/**
 * @author renlei 
 * @E-mail:renlei0109@yeah.net
 * @version ����ʱ�䣺2014-5-31 ����5:57:07 ��˵��
 */
public interface ResturantDao {
	public List<Resturant> findResturantByNormal(double longitude,double latitude);
	public List<Resturant>findResturantByMonthSell(double longitude,double latitude);
	public List<Resturant>findResturantByMoney(double longitude,double latitude);
	public List<Resturant>findResturantByDistance(double longitude,double latitude);
	
}
