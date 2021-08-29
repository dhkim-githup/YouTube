package com.model2.spring.di.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.model2.spring.di.comm.DbConn;
import com.model2.spring.di.controller.PeopleList;
import com.model2.spring.di.vo.People;
import com.model2.spring.di.vo.People_lombok;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PeopleService {
	
	String name;
	
	
	public List<People> doSelect(){
		
	
		Connection conn = null; // DB 에 connection 된 객체를 저장 
	    PreparedStatement ps = null;  // connection 객체에 실행문을 던지는 역할(창구)
	    ResultSet rs = null;     // select 결과값을 받아옮
	    String qry="";
		DbConn dbConn = new DbConn();	    
		conn = dbConn.getConn();
		
		List<People> list = new ArrayList<>();
		
		 try{ 
			    /* Result Set , Print */	
				qry = " select id, name, age, to_char(reg_date,'yyyy.mm.dd') as dati " 
					+" from people ";
				
				ps = conn.prepareStatement(qry);
				rs = ps.executeQuery();
				log.info(qry);
				while(rs.next()) {
					// Poeple 생성자를 이용하여 값을 입력 
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
	
	public List<People_lombok> doSelect_lombok(){
		
		
		Connection conn = null; // DB 에 connection 된 객체를 저장 
	    PreparedStatement ps = null;  // connection 객체에 실행문을 던지는 역할(창구)
	    ResultSet rs = null;     // select 결과값을 받아옮
	    String qry="";
		DbConn dbConn = new DbConn();	    
		conn = dbConn.getConn();
		
		List<People_lombok> list = new ArrayList<>();
		
		 try{ 
			    /* Result Set , Print */	
				qry = " select id, name, age, to_char(reg_date,'yyyy.mm.dd') as dati " 
					+" from people ";
				
				ps = conn.prepareStatement(qry);
				rs = ps.executeQuery();
				
				log.info(qry);
				
				while(rs.next()) {
					// Poeple 생성자를 이용하여 값을 입력 
					//People_lombok people_lombok = new People_lombok(rs.getString("id"), rs.getString("name"), rs.getString("age"), rs.getString("dati"));
					People_lombok people_lombok = People_lombok.builder()
											      .strID(rs.getString("id"))
											      .strAge(rs.getString("age"))
											      .strDati(rs.getString("dati"))
											      .strName(rs.getString("name"))
											      .build();
					
					log.info(people_lombok.toString());
					System.out.println(people_lombok.toString());
					list.add(people_lombok);
					
				}
				
				System.out.println(list.size());
				System.out.println("Model 2 , Lombok , builder");
			
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
	
	@PostConstruct
	public void init() {
	  System.out.println("PeopleService- init");
	}
	
	@PreDestroy
	public void destroy() {
	  System.out.println("PeopleService -destroy");
	}

}
