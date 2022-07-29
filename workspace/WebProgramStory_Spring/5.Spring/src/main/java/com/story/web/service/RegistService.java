package com.story.web.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;
import com.story.web.comm.*;
import com.story.web.vo.People;


@Service
public class RegistService {


	public int doInsert(String strID, String strName, String strAge){

		int intI =0;
		Connection conn = null; // DB �� connection �� ��ü�� ����
	    PreparedStatement ps = null;  // connection ��ü�� ���๮�� ������ ����(â��)
	    ResultSet rs = null;     // select ������� �޾ƿ�
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

				System.out.println("ID "+strID+" �� ��� �߽��ϴ�.");

				System.out.println("Spring");

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