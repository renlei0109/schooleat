/**
 * 
 */
package cn.com.school.eat.code.service;

import java.util.List;

import cn.com.school.eat.code.entity.Resturant;

/**
 * @author renlei 
 * @E-mail:renlei0109@yeah.net
 * @version 创建时间：2014-5-31 下午6:19:13 简单说明
 */
public interface ResturantService {
	public List<Resturant> getResturantByNormal(double longitude,double latitude);
	public List<Resturant> getResturantByMonthSell(double longitude,double latitude);
	public List<Resturant> getResturantByMoney(double longitude,double latitude);
	public List<Resturant> getResturantByDistance(double longitude,double latitude);
}	
