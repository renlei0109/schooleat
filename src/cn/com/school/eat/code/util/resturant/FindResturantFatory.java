/**
 * 
 */
package cn.com.school.eat.code.util.resturant;

import org.springframework.stereotype.Component;

/**
 * @author renlei 
 * @E-mail:renlei0109@yeah.net
 * @version 创建时间：2014-5-31 下午5:48:05 简单说明
 */
@Component("findResturantFatory")
public class FindResturantFatory {
	/**
	 * 
	 * @return
	 * 通过距离寻找餐馆
	 */
	public static FindResturant createFinResByDis(){
		return new FindResturantByDistance();
	}
	/**
	 * 
	 * @return
	 * 通过月销量寻找餐馆
	 */
	public static FindResturant createFinResByMonSell(){
		return new FindResturantByMonthSell();
	}
	/**
	 * @return
	 * 正常情况下寻找餐馆
	 */
	public static FindResturant createFinResByNormal(){
		return new FindResutrantByNormal();
	}
	
	public static FindResturant createFinResByMoney(){
		return new FindResturantByMoney();
	}
}
