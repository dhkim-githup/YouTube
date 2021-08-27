package com.model2.spring.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.model2.spring.jdbc.comm.DbConn;
import com.model2.spring.vo.Vo_People;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class Dao_People {
	
	Connection conn = null; // DB 에 connection 된 객체를 저장 
    PreparedStatement ps = null;  // connection 객체에 실행문을 던지는 역할(창구)
    ResultSet rs = null;     // select 결과값을 받아옮
    

	/* People 의 값을 전부 가져오는 메서드 */
	public List<Vo_People> doReadList() {
		
		String qry="";
		DbConn dbConn = new DbConn();	    
		conn = dbConn.getConn();
		
		List<Vo_People> list = new ArrayList<>();
		
		try{ 
		    /* Result Set , Print */	
			qry = " select id, name, age, to_char(reg_date,'yyyy.mm.dd') as dati " 
				+" from people "
				+ " order by id ";
			
			ps = conn.prepareStatement(qry);
			log.info(qry);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				// Poeple 생성자를 이용하여 값을 입력 				
				Vo_People vo_People = new Vo_People(rs.getString("id"), rs.getString("name"), rs.getString("age"), rs.getString("dati"));
				list.add(vo_People);	
				
			}
			
			log.info("doReadList"+list.size());
			
		
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

	/* 특정 ID 값을 져오는 메서드 */	
	public Vo_People doReadId(String id) {
		
		String qry="";
		DbConn dbConn = new DbConn();	    
		conn = dbConn.getConn();
	
		Vo_People vo_People=null;
		
		try{ 
		    /* Result Set , Print */	
			qry = " select id, name, age, to_char(reg_date,'yyyy.mm.dd') as dati " 
				+" from people "
				+" where id = ? "
				;
			
			ps = conn.prepareStatement(qry);
			ps.setString(1, id);
			rs = ps.executeQuery();
			log.info(qry);
			if(rs.next()) {
				// Poeple 생성자를 이용하여 값을 입력 				
				vo_People = new Vo_People(rs.getString("id"), rs.getString("name"), rs.getString("age"), rs.getString("dati"));
				
			}
			
			log.info("doReadId"+id);
			
		
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
		
		return vo_People;
	}

	/* ID 를 생성하는 메서드 */
	public int doCreate(Vo_People vo_People) {
		
		String qry="";
		DbConn dbConn = new DbConn();	    
		conn = dbConn.getConn();
		
		int intI =0;
				
		 try{ 
			   
			 /* Result Set , Print */	
				qry = " Insert into people(id, name, age) "
					 +" values (? , ?, to_number(?))";
			     
				ps = conn.prepareStatement(qry);			
				ps.setString(1, vo_People.getId());
				ps.setString(2, vo_People.getName());
				ps.setString(3, vo_People.getAge());			
				log.info(qry);
				
				intI = ps.executeUpdate();
				
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
		 
		 log.info("doCreate"); 
		 
		return intI;
	}

	/* ID 를 수정하는 메서드 */
	public int doUpdate(Vo_People vo_People) {
		
		String qry="";
		DbConn dbConn = new DbConn();	    
		conn = dbConn.getConn();
		
		int intI =0;
				
		 try{ 
			   
			 /* Result Set , Print */	
				qry = " update people "
					 +" SET "
					 +" name =?, age =? "
					 +" WHERE id = ?"
					 ;					 
			     
				ps = conn.prepareStatement(qry);			
				ps.setString(1, vo_People.getName());
				ps.setString(2, vo_People.getAge());			
				ps.setString(3, vo_People.getId());
				
				log.info(qry);
				intI = ps.executeUpdate();
				
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
		 
		 log.info("doCreate"); 
		 
		return intI;
	}

	/* ID 를 삭제하는 메서드 */
	public int doDelete(String id) {
		
		String qry="";
		DbConn dbConn = new DbConn();	    
		conn = dbConn.getConn();
		
		int intI =0;		
				
		 try{ 
			   
			 /* Result Set , Print */	
				qry = " Delete from people "
					 +" WHERE id = ?"
					 ;					 
			     
				ps = conn.prepareStatement(qry);			
				ps.setString(1, id);
				log.info(qry);
				
				intI = ps.executeUpdate();
				
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
		 
		 log.info("doCreate"); 
		 
		return intI;
		
	}

}
