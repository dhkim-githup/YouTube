package com.story.web.comm;

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
		    
		    /* Transaction 처리를 사용자가 직접 하도록 한다 */
		    conn.setAutoCommit(false); 

		    System.out.println("OK Connection");

		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return conn;
	}


}