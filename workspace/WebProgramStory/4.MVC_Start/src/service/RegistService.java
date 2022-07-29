package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import comm.DbConn;
import vo.People;

public class RegistService {
	
	
	public int doInsert(String strID, String strName, String strAge){
	
		int intI =0;
		Connection conn = null; // DB 에 connection 된 객체를 저장 
	    PreparedStatement ps = null;  // connection 객체에 실행문을 던지는 역할(창구)
	    ResultSet rs = null;     // select 결과값을 받아옮
	    String qry="";
		DbConn dbConn = new DbConn();	    
		conn = dbConn.getConn();
				
		 try{ 
			   
			 /* Result Set , Print */	
				qry = " Insert into people(id, name, age) "
					 +" values (? , ?, to_number(?))";
			     
				ps = conn.prepareStatement(qry);			
				ps.setString(1, strID);
				ps.setString(2, strName);
				ps.setString(3, strAge);			
				
				ps.executeUpdate();
				
				System.out.println("ID "+strID+" 를 등록 했습니다.");
				
				System.out.println("Model 2");
			
		   }catch (Exception e) {
			    intI = 1;
				System.out.println("Error =>"+e);			
			 }finally {
				 /* Close */ 
				try {
					if(rs != null) rs.close();
					if(ps != null) ps.close();
					if(conn != null) conn.close();			
				}catch (Exception e2) {			
				}
			}	
		 
		 return intI;
		
		
	}

}