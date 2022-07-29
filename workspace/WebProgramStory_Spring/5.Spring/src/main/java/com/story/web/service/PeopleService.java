package com.story.web.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import com.story.web.comm.DbConn;
import com.story.web.vo.People;

@Component
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
				
				while(rs.next()) {
					// Poeple 생성자를 이용하여 값을 입력
					People people = new People(rs.getString("id"), rs.getString("name"), rs.getString("age"), rs.getString("dati"));
					list.add(people);

				}

				System.out.println(list.size());
				System.out.println("Spring");

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