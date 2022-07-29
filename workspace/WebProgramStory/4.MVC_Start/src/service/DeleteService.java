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
		Connection conn = null; // DB �� connection �� ��ü�� ���� 
	    PreparedStatement ps = null;  // connection ��ü�� ���๮�� ������ ����(â��)
	    ResultSet rs = null;     // select ������� �޾ƿ�
	    String qry="";
		DbConn dbConn = new DbConn();	    
		conn = dbConn.getConn();
				
		 try{ 
			       
			     /* Result Set , Print */	
				qry = " delete from people where id=?";
				 
				ps = conn.prepareStatement(qry);			
				ps.setString(1, strID);
				
				ps.executeUpdate();
				
				System.out.println("ID "+strID+" �� ���� �߽��ϴ�.");				
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