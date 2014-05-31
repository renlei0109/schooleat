
package cn.com.school.eat.code.util.resturant;

import java.util.List;

import cn.com.school.eat.code.entity.Resturant;

/**
 * @author renlei 
 * @E-mail:renlei0109@yeah.net
 * @version 创建时间：2014-5-31 下午2:06:41 简单说明
 * 根据经纬度查找餐厅的接口
 */
public interface FindResturant{
	/**
	 * 根据经纬度计算离该商家一定范围内的商家
	 * @param longitude  经度
	 * @param latitude   纬度
	 * @return
	 */
	public List<Resturant> findResturants(double longitude,double latitude);
}
