/**
 * 
 */
package cn.com.school.eat.code.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.school.eat.code.dao.ResturantDao;
import cn.com.school.eat.code.entity.Resturant;
import cn.com.school.eat.code.util.resturant.FindResturant;
import cn.com.school.eat.code.util.resturant.FindResturantFatory;

/**
 * @author renlei 
 * @E-mail:renlei0109@yeah.net
 * @version 创建时间：2014-5-31 下午6:05:06 简单说明
 */
@Component("resturantDao")
public class ResturantDaoImpl implements ResturantDao{
	private FindResturantFatory findResturantFatory;
	private List<Resturant>resturants = null;
	public FindResturantFatory getFindResturantFatory() {
		return findResturantFatory;
	}
	@Resource
	public void setFindResturantFatory(FindResturantFatory findResturantFatory) {
		this.findResturantFatory = findResturantFatory;
	}

	/* (non-Javadoc)
	 * @see cn.com.school.eat.code.dao.ResturantDao#findResturantByNormal(double, double)
	 */
	@Override
	public List<Resturant> findResturantByNormal(double longitude,
			double latitude) {
		resturants = findResturantFatory.createFinResByNormal().findResturants(longitude, latitude);
		if(null!=resturants)
			return resturants;
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.com.school.eat.code.dao.ResturantDao#findResturantByMonthSell(double, double)
	 */
	@Override
	public List<Resturant> findResturantByMonthSell(double longitude,
			double latitude) {
		resturants = findResturantFatory.createFinResByMonSell().findResturants(longitude, latitude);
		if(null!=resturants)
			return resturants;
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.com.school.eat.code.dao.ResturantDao#findResturantByMoney(double, double)
	 */
	@Override
	public List<Resturant> findResturantByMoney(double longitude,
			double latitude) {
		resturants = findResturantFatory.createFinResByMoney().findResturants(longitude, latitude);
		if(null!=resturants)
			return resturants;
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.com.school.eat.code.dao.ResturantDao#findResturantByDistance(double, double)
	 */
	@Override
	public List<Resturant> findResturantByDistance(double longitude,
			double latitude) {
		resturants = findResturantFatory.createFinResByDis().findResturants(longitude, latitude);
		if(null != resturants)
			return resturants;
		return null;
	}




	
	
}
