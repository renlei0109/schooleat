/**
 * 
 */
package cn.com.school.eat.code.util.resturant;

import org.springframework.stereotype.Component;

/**
 * @author renlei 
 * @E-mail:renlei0109@yeah.net
 * @version ����ʱ�䣺2014-5-31 ����5:48:05 ��˵��
 */
@Component("findResturantFatory")
public class FindResturantFatory {
	/**
	 * 
	 * @return
	 * ͨ������Ѱ�Ҳ͹�
	 */
	public static FindResturant createFinResByDis(){
		return new FindResturantByDistance();
	}
	/**
	 * 
	 * @return
	 * ͨ��������Ѱ�Ҳ͹�
	 */
	public static FindResturant createFinResByMonSell(){
		return new FindResturantByMonthSell();
	}
	/**
	 * @return
	 * ���������Ѱ�Ҳ͹�
	 */
	public static FindResturant createFinResByNormal(){
		return new FindResutrantByNormal();
	}
	
	public static FindResturant createFinResByMoney(){
		return new FindResturantByMoney();
	}
}
