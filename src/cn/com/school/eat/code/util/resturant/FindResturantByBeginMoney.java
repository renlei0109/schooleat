/**
 * 
 */
package cn.com.school.eat.code.util.resturant;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import cn.com.school.eat.code.entity.Resturant;

/**
 * @author renlei 
 * @E-mail:renlei0109@yeah.net
 * @version 创建时间：2014-6-1 下午4:27:45 简单说明
 * 按起送价进行排序
 */
@Component
public class FindResturantByBeginMoney implements FindResturant{
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	/* (non-Javadoc)
	 * @see cn.com.school.eat.code.util.resturant.FindResturant#findResturants(double, double)
	 */
	@Override
	public List<Resturant> findResturants(double longitude, double latitude) {
		List<Resturant> resturants = null;
		String hql = "from Resturant r where sqrt(   " +
				"(  (("+longitude+"-r.x)*PI()*12656*cos((("+latitude+"+r.y)/2)*PI()/180)/180) " +
				"  *  " +
				"(("+longitude+"-r.x)*PI()*12656*cos ((("+latitude+"+r.y)/2)*PI()/180)/180)  " +
				")  " +
				"+  " +
				"(  " +
				"(( "+latitude+" -r.y)*PI()*12656/180)  " +
				" *  " +
				"(("+latitude+"-r.y)*PI()*12656/180)  " +
				")  " +
				")<2  " +
				" order by  sqrt(   " +
				"(  (("+longitude+"-r.x)*PI()*12656*cos((("+latitude+"+r.y)/2)*PI()/180)/180) " +
				"  *  " +
				"(("+longitude+"-r.x)*PI()*12656*cos ((("+latitude+"+r.y)/2)*PI()/180)/180)  " +
				")  " +
				"+  " +
				"(  " +
				"(( "+latitude+" -r.y)*PI()*12656/180)  " +
				" *  " +
				"(("+latitude+"-r.y)*PI()*12656/180)  " +
				")  " +
				")  order by beginmoney";
		resturants = hibernateTemplate.find(hql);
		if(null != resturants)
			return resturants;
		return null;
	}
	
}
