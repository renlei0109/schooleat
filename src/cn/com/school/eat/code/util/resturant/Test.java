/**
 * 
 */
package cn.com.school.eat.code.util.resturant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import cn.com.school.eat.code.entity.Resturant;

/**
 * @author renlei 
 * @E-mail:renlei0109@yeah.net
 * @version 创建时间：2014-5-31 下午2:48:11 简单说明
 */
public class Test {
public List<Resturant> findResturants(double longitude, double latitude) {
		Connection connection = DB.getConnection();
		
		String hql = "select * from Resturant r where sqrt(   " +
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
				")<2  ";
		try {
			PreparedStatement statement = connection.prepareStatement(hql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				System.out.println(resultSet.getString("resturant_name"));
			}
			List<Resturant>resturants = null;
			return resturants;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}


public static void main(String []args){
	new Test().findResturants(100, 122);
}
}
