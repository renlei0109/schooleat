/**
 * 
 */
package cn.com.school.eat.code.util.resturant;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.com.school.eat.code.entity.Resturant;

/**
 * @author renlei 
 * @E-mail:renlei0109@yeah.net
 * @version 创建时间：2014-5-31 下午3:15:25 简单说明
 */
public class FindResturantByDistance implements FindResturant{

	private HibernateTemplate hibernateTemplate ;
	
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
				"(  (("+longitude+"-r.longitude)*PI()*12656*cos((("+latitude+"+r.latitude)/2)*PI()/180)/180) " +
				"  *  " +
				"(("+longitude+"-r.longitude)*PI()*12656*cos ((("+latitude+"+r.latitude)/2)*PI()/180)/180)  " +
				")  " +
				"+  " +
				"(  " +
				"(( "+latitude+" -r.latitude)*PI()*12656/180)  " +
				" *  " +
				"(("+latitude+"-r.latitude)*PI()*12656/180)  " +
				")  " +
				")<2  " +
				" order by  sqrt(   " +
				"(  (("+longitude+"-r.longitude)*PI()*12656*cos((("+latitude+"+r.latitude)/2)*PI()/180)/180) " +
				"  *  " +
				"(("+longitude+"-r.longitude)*PI()*12656*cos ((("+latitude+"+r.latitude)/2)*PI()/180)/180)  " +
				")  " +
				"+  " +
				"(  " +
				"(( "+latitude+" -r.latitude)*PI()*12656/180)  " +
				" *  " +
				"(("+latitude+"-r.latitude)*PI()*12656/180)  " +
				")  " +
				")  ";
		resturants = hibernateTemplate.find(hql);
		if(null != resturants)
			return resturants;
		return null;
	}
	
}
