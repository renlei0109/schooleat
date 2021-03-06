package cn.com.school.eat.code.dao.impl;

import java.util.List;
import java.util.Random;

import cn.com.school.eat.code.entity.*;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import cn.com.school.eat.code.dao.OtherDao;
import cn.com.school.eat.code.entity.Address;
import cn.com.school.eat.code.entity.Dish;
import cn.com.school.eat.code.entity.Dish_Rec;

@Component
@SuppressWarnings("unchecked")
public class OtherDaoImpl implements OtherDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public Dish Shake() {
		String hql1 = "select count(*) from Dish";
		List<Object> list = hibernateTemplate.find(hql1);
		System.out.println(list.get(0)+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		Random random = new Random();
		int num = Integer.valueOf(list.get(0).toString());
		final int i = random.nextInt(num);
		final int j = num + 1;
		List<Dish> result = hibernateTemplate
				.executeFind(new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query = session.createQuery("from Dish");
						query.setMaxResults(j);
						query.setFirstResult(i);
						return query.list();
					}
				});
		return result.get(0);
		
		
	}


	@Override
	public List<Dish_Rec> Home_IMG(int page) {
		final int pagecount = (page - 1) * 5;
		// final String hql = "from Dish_Rec limit ?,?";
		// List<Dish_Rec> result = hibernateTemplate.find(hql);
		List<Dish_Rec> result = hibernateTemplate
				.executeFind(new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query = session.createQuery("from Dish_Rec");
						query.setMaxResults(5);
						query.setFirstResult(pagecount);
						return query.list();
					}
				});
		return result;
	}

	@Override
	public Dish Zhai(String user_id) {
		System.out.println(user_id);
		String hql1 = "from User where user_id = ? ";
		List<User> users = hibernateTemplate.find(hql1,
				new Object[] { user_id });
		System.out.println(users.size());
		User user = users.get(0);
		System.out.println(user);
		String binding = user.getBinding();
		String hql2 = "from Dish where dish_id = ? ";
		List<Dish> list2 = hibernateTemplate.find(hql2,
				new Object[] { binding });
		return list2.get(0);
	}


	@Override
	public List<Address> QueryAddress(String owner_id) {

		String hql1 = "from Address where  owner_id= ? ";
		List<Address> result = hibernateTemplate.find(hql1,
				new Object[] { owner_id });
		return result;

	}

	@Override
	public String AddAddress(Address address) {
		hibernateTemplate.save(address);
		hibernateTemplate.flush();
		return "success";
	}

	@Override
	public String ChangeAddress(Address address) {
		hibernateTemplate.update(address);
		hibernateTemplate.flush();
		return "success";
	}

	@Override
	public String DeleteAddress(String user_id, String address_id) {
		String hql1 = "from Address where user_id = ? and address_id = ?";
		List<Address> list = hibernateTemplate.find(hql1, new Object[] {
				user_id, address_id });
		hibernateTemplate.delete(list.get(0));
		hibernateTemplate.flush();
		return "success";
	}

	@Override
	public String Suggest(String user_id, String content) {

		Suggest suggest = new Suggest();
		suggest.setContent(content);
		suggest.setResult("0");
		suggest.setUser_id(user_id);
		hibernateTemplate.save(suggest);
		hibernateTemplate.flush();
		return "success";
	}

}
