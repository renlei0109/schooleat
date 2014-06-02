/**
 * 
 */
package cn.com.school.eat.code.util.resturant;

import java.util.ArrayList;
import java.util.List;

import cn.com.school.eat.code.entity.Resturant;

/**
 * @author renlei 
 * @E-mail:renlei0109@yeah.net
 * @version ����ʱ�䣺2014-6-1 ����1:43:38 ��˵��
 */
public class ResturantUtil {
	
	private static final double EARTH_RADIUS = 6378137;
	    private static double rad(double d)
	    {
	       return d * Math.PI / 180.0;
	    }
	    
	    /**
	     * ��������侭γ�����꣨doubleֵ���������������룬��λΪ��
	     * @param lng1
	     * @param lat1
	     * @return
	     */
	
	public List<Double> getDistance(double longitude, double latitude,List<Resturant>resturants){
		List<Double>distances = new ArrayList<Double>();
		for(Resturant resturant:resturants){
			   double radLat1 = rad(latitude);
		       double radLat2 = rad(resturant.getY());
		       double a = radLat1 - radLat2;
		       double b = rad(longitude) - rad(resturant.getX());
		       double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) + 
		        Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
		       s = s * EARTH_RADIUS;
		       s = Math.round(s * 10000) / 10000;
		       distances.add(s);
		}
		if(distances.size()>0)
			return distances;
		return null;
		
	}
}
