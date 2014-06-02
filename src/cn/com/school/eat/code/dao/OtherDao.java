package cn.com.school.eat.code.dao;

import java.util.List;

import cn.com.school.eat.code.entity.Address;
import cn.com.school.eat.code.entity.Dish;
import cn.com.school.eat.code.entity.Dish_Rec;

public interface OtherDao {

	public Dish Shake();

	public List<Dish_Rec> Home_IMG(int page);

	public Dish Zhai(String user_id);

	public List<Address> QueryAddress(String owner_id);

	public String AddAddress(Address address);

	public String ChangeAddress(Address address);

	public String DeleteAddress(String user_id, String address_id);

	public String Suggest(String user_id, String content);

}
