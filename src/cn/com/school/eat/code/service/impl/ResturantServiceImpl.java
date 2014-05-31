/**
 * 
 */
package cn.com.school.eat.code.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.school.eat.code.dao.ResturantDao;
import cn.com.school.eat.code.entity.Resturant;
import cn.com.school.eat.code.service.ResturantService;

/**
 * @author renlei 
 * @E-mail:renlei0109@yeah.net
 * @version 创建时间：2014-5-31 下午6:20:07 简单说明
 */
@Component("resturantService")
public class ResturantServiceImpl implements ResturantService{

	private ResturantDao resturantDao;
	
	public ResturantDao getResturantDao() {
		return resturantDao;
	}
	@Resource
	public void setResturantDao(ResturantDao resturantDao) {
		this.resturantDao = resturantDao;
	}

	/* (non-Javadoc)
	 * @see cn.com.school.eat.code.service.ResturantService#getResturantByNormal(double, double)
	 */
	@Override
	public List<Resturant> getResturantByNormal(double longitude,
			double latitude) {
		// TODO Auto-generated method stub
		return resturantDao.findResturantByNormal(longitude, latitude);
	}

	/* (non-Javadoc)
	 * @see cn.com.school.eat.code.service.ResturantService#getResturantByMonthSell(double, double)
	 */
	@Override
	public List<Resturant> getResturantByMonthSell(double longitude,
			double latitude) {
		// TODO Auto-generated method stub
		return resturantDao.findResturantByMonthSell(longitude, latitude);
	}

	/* (non-Javadoc)
	 * @see cn.com.school.eat.code.service.ResturantService#getResturantByMoney(double, double)
	 */
	@Override
	public List<Resturant> getResturantByMoney(double longitude, double latitude) {
		// TODO Auto-generated method stub
		return resturantDao.findResturantByMoney(longitude, latitude);
	}

	/* (non-Javadoc)
	 * @see cn.com.school.eat.code.service.ResturantService#getResturantByDistance(double, double)
	 */
	@Override
	public List<Resturant> getResturantByDistance(double longitude,
			double latitude) {
		// TODO Auto-generated method stub
		return resturantDao.findResturantByDistance(longitude, latitude);
	}

}
