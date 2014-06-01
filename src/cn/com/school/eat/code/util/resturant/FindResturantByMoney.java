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
 * @version 创建时间：2014-5-31 下午6:09:29 简单说明
 */
@Component
public class FindResturantByMoney implements FindResturant{


	private HibernateTemplate hibernateTemplate;
	
	/* (non-Javadoc)
	 * @see cn.com.school.eat.code.util.resturant.FindResturant#findResturants(double, double)
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<Resturant> findResturants(double longitude, double latitude) {
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
				")<2 order by r.total_money";
		List<Resturant>resturants = hibernateTemplate.find(hql);
			if(null!=resturants)
				return resturants;
		return null;
	}
	
}
