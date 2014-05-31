package cn.com.school.eat.code.util.resturant;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class DB {
	public static Connection getConnection(){
		String driver="com.mysql.jdbc.Driver";
		//主机数据�?
		String url="jdbc:mysql//localhost:3307/eat";				
		String user="root";
		String password ="010910";
		//自测数据�?
		//String url = "jdbc:mysql://localhost/lbsserver";
		//String user = "root";
		//String password = "wytzv5a";
		//sb数据�?
		//String url = "jdbc:mysql://192.168.2.104/lbsserver";
		//String user = "broker";
		//String password = "123456";
		try {
				Class.forName(driver);
				Connection connection= DriverManager.getConnection(url, user, password);
				if(connection!=null){
					//System.out.print("YES");
				//}else{
					//System.out.print("No");
					return connection;
				}
				
				
			  
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public static void closeRs(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static  void closePstmt(PreparedStatement pstm){
		if(pstm!=null){
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	
	
	public static void closeConn(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	//public static void main(String[] args){
	//	Connection conn = DB.getConnection();
	//	if(conn!=null){
	//		System.out.println("aa");
	//	}

	//}
}