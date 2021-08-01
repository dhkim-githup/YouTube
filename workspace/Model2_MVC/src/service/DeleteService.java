package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import comm.DbConn;
import vo.People;

public class DeleteService {
	
	
	public int doDelete(String strID){
	
		int intI =0;
		Connection conn = null; // DB 에 connection 된 객체를 저장 
	    PreparedStatement ps = null;  // connection 객체에 실행문을 던지는 역할(창구)
	    ResultSet rs = null;     // select 결과값을 받아옮
	    String qry="";
		DbConn dbConn = new DbConn();	    
		conn = dbConn.getConn();
				
		 try{ 
			       
			     /* Result Set , Print */	
				qry = " delete from people where id=?";
				 
				ps = conn.prepareStatement(qry);			
				ps.setString(1, strID);
				
				ps.executeUpdate();
				
				System.out.println("ID "+strID+" 를 삭제 했습니다.");				
				System.out.println("Model 2, doDelete");
			
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
