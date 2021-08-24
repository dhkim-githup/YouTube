package com.model2.spring.di.comm;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConn {

	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String dbURL="jdbc:oracle:thin:@localhost:1521:xe";
	String user_id="scott";        
	String user_pw="tiger";
	String qry="";

	private Connection conn = null; // DB 에 connection 된 객체를 저장 
	
	public Connection getConn(){
		
		try{
			/* Driver Loading */
		    Class.forName(driver);
		    conn = DriverManager.getConnection(dbURL, user_id, user_pw);
		    
		    System.out.println("OK Connection");
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return conn;
	}
	
	
}
