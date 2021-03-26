package com.hig.oracleformsmigration.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
	
	public static Connection getDBConnection() throws Exception{
		Connection con = null;
		try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 con = DriverManager.getConnection("jdbc:oracle:thin:@oramigr.cy4nbk6ruiaf.us-west-2.rds.amazonaws.com:1521:oramigr","admin","BigDataAnalytics6");
			 return con;
//			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return con;
	}
	
	public static void closeDBConnection (Connection con) throws Exception {
		
		try {
			if (!con.isClosed()) {
				con.close();	
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}