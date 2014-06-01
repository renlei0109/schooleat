/**
 * 
 */
package cn.com.school.eat.code.util.resturant;

import javax.annotation.Resource;

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
	private  FindResutrantByNormal findResutrantByNormal;
	private  FindResturantByMoney findResturantByMoney;
	private  FindResturantByMonthSell findResturantByMonthSell;
	private  FindResturantByDistance findResturantByDistance;
	
	public FindResturantByMoney getFindResturantByMoney() {
		return findResturantByMoney;
	}
	@Resource
	public void setFindResturantByMoney(FindResturantByMoney findResturantByMoney) {
		this.findResturantByMoney = findResturantByMoney;
	}
	public FindResturantByMonthSell getFindResturantByMonthSell() {
		return findResturantByMonthSell;
	}
	@Resource
	public void setFindResturantByMonthSell(
			FindResturantByMonthSell findResturantByMonthSell) {
		this.findResturantByMonthSell = findResturantByMonthSell;
	}
	public FindResturantByDistance getFindResturantByDistance() {
		return findResturantByDistance;
	}
	@Resource
	public void setFindResturantByDistance(
			FindResturantByDistance findResturantByDistance) {
		this.findResturantByDistance = findResturantByDistance;
	}
	public FindResutrantByNormal getFindResutrantByNormal() {
		return findResutrantByNormal;
	}
	@Resource
	public void setFindResutrantByNormal(FindResutrantByNormal findResutrantByNormal) {
		this.findResutrantByNormal = findResutrantByNormal;
	}
	public  FindResturant createFinResByDis(){
		return findResturantByDistance;
	}
	/**
	 * 
	 * @return
	 * ͨ��������Ѱ�Ҳ͹�
	 */
	public  FindResturant createFinResByMonSell(){
		return  findResturantByMonthSell;
	}
	/**
	 * @return
	 * ���������Ѱ�Ҳ͹�
	 */
	public  FindResturant createFinResByNormal(){
		return findResutrantByNormal;
	}
	
	public  FindResturant createFinResByMoney(){
		return findResturantByMoney;
	}
}
