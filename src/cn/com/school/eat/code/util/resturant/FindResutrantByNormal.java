/**
 * 
 */
package cn.com.school.eat.code.util.resturant;

import java.util.List;

import javax.annotation.Resource;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import cn.com.school.eat.code.entity.Resturant;

/**
 * @author renlei 
 * @E-mail:renlei0109@yeah.net
 * @version ����ʱ�䣺2014-5-31 ����2:15:49 ��˵��
 * ����ͨ������ص�ǰ�͹�
 */
@Component
public class FindResutrantByNormal implements FindResturant{

	private HibernateTemplate  hibernateTemplate;
	
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
		System.out.println(longitude+"&^&*&*"+latitude);
		String hql = "from Resturant r where sqrt(" +
				"((("+longitude+"-r.x)*PI()*12656*cos((("+latitude+"+r.y)/2)*PI()/180)/180) " +
				"  *  " +
				"(("+longitude+"-r.x)*PI()*12656*cos ((("+latitude+"+r.y)/2)*PI()/180)/180)  " +
				")  " +
				"+  " +
				"(  " +
				"(( "+latitude+" -r.y)*PI()*12656/180)  " +
				" *  " +
				"(("+latitude+"-r.y)*PI()*12656/180)  " +
				")  " +
				")<2 ";
		List<Resturant>resturants = hibernateTemplate.find(hql);
		System.out.println(resturants.get(0).toString());
		return resturants;
	}
	
}
