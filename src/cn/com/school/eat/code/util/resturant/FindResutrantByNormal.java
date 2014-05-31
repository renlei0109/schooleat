/**
 * 
 */
package cn.com.school.eat.code.util.resturant;

import java.util.List;

import javax.annotation.Resource;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.com.school.eat.code.entity.Resturant;

/**
 * @author renlei 
 * @E-mail:renlei0109@yeah.net
 * @version 创建时间：2014-5-31 下午2:15:49 简单说明
 * 按普通情况返回当前餐馆
 */
public class FindResutrantByNormal implements FindResturant{

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
				")<2 ";
		List<Resturant>resturants = hibernateTemplate.find(hql,new Object[]{longitude,latitude});
		return resturants;
	}
	
}
