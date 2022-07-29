package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import comm.DbConn;
import vo.People;

public class PeopleService {
	
	List<People> list = new ArrayList<>();
	
	public List<People> doSelect(){
	
		Connection conn = null; // DB �� connection �� ��ü�� ���� 
	    PreparedStatement ps = null;  // connection ��ü�� ���๮�� ������ ����(â��)
	    ResultSet rs = null;     // select ������� �޾ƿ�
	    String qry="";
		DbConn dbConn = new DbConn();	    
		conn = dbConn.getConn();
				
		 try{ 
			    /* Result Set , Print */	
				qry = " select id, name, age, to_char(reg_date,'yyyy.mm.dd') as dati " 
					+" from people ";
				
				ps = conn.prepareStatement(qry);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					// Poeple �����ڸ� �̿��Ͽ� ���� �Է� 
					People people = new People(rs.getString("id"), rs.getString("name"), rs.getString("age"), rs.getString("dati"));
					list.add(people);				
				}
				
				System.out.println(list.size());
				System.out.println("Model 2");
			
		   }catch (Exception e) {
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
		
		  return list;
	}

}