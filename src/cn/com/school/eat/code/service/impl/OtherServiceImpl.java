package cn.com.school.eat.code.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.school.eat.code.dao.OtherDao;
import cn.com.school.eat.code.entity.Address;
import cn.com.school.eat.code.entity.Dish;
import cn.com.school.eat.code.entity.Dish_Rec;
import cn.com.school.eat.code.service.OtherService;

@Component
public class OtherServiceImpl implements OtherService {

	private OtherDao otherDao;

	public OtherDao getOtherDao() {
		return otherDao;
	}

	@Resource
	public void setOtherDao(OtherDao otherDao) {
		this.otherDao = otherDao;
	}

	@Override
	public Dish Shake() {

		Dish dish = otherDao.Shake();

		return dish;
	}

	@Override
	public List<Dish_Rec> Home_IMG() {
		List<Dish_Rec> result = otherDao.Home_IMG();
		return result;
	}

	@Override
	public Dish Zhai(String user_id) {
		Dish dish = otherDao.Zhai(user_id);
		return dish;
	}

	@Override
	public List<Address> QueryAddress(String owner_id) {
		List<Address> result = otherDao.QueryAddress(owner_id);
		return result;
	}

	@Override
	public String AddAddress(Address address) {
		String result = otherDao.AddAddress(address);
		return result;
	}

	@Override
	public String ChangeAddress(Address address) {
		String result = otherDao.ChangeAddress(address);
		return result;
	}

	@Override
	public String DeleteAddress(String user_id, String address_id) {
		String result = otherDao.DeleteAddress(user_id, address_id);
		return result;
	}

	@Override
	public String Suggest(String user_id, String content) {
		String result = otherDao.Suggest(user_id, content);
		return result;
	}

}
