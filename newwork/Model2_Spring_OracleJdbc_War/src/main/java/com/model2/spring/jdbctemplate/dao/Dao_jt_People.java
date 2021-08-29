package com.model2.spring.jdbctemplate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.model2.spring.vo.Vo_People;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class Dao_jt_People {
	
	@Autowired
	JdbcTemplate template;

	/* People 의 값을 전부 가져오는 메서드 */
	public List<Vo_People> doReadList() {
		
		String qry="";
			
		List<Vo_People> list = new ArrayList<>();
		
		try{ 
		    /* Result Set , Print */	
			qry = " select id, name, age, to_char(reg_date,'yyyy.mm.dd') as dati " 
				+" from people "
				+ " order by id ";
			
			log.info(qry);
			
			list = template.query(qry,  new BeanPropertyRowMapper<Vo_People>(Vo_People.class));
			
			log.info("doReadList"+list.size());
			
		
	   }catch (Exception e) {
			System.out.println("Error =>"+e);			
		 }finally {
		}		
		
		return list;
	}

	/* 특정 ID 값을 져오는 메서드 */	
	public Vo_People doReadId(String id) {
		
		String qry="";
			
		Vo_People vo_People=null;
		
		try{ 
		    /* Result Set , Print */	
			qry = " select id, name, age, to_char(reg_date,'yyyy.mm.dd') as dati " 
				+" from people "
				+" where id = ? "
				;
			
			log.info(qry);
			
			vo_People = template.queryForObject(qry, new BeanPropertyRowMapper<Vo_People>(Vo_People.class),id);
			
			
			log.info("doReadId"+id);
			
		
	   }catch (Exception e) {
			System.out.println("Error =>"+e);			
		 }finally {
		}		
		
		return vo_People;
	}

	/* ID 를 생성하는 메서드 */
	public int doCreate(Vo_People vo_People) {
		
		String qry="";
	
		int intI =0;
				
		 try{ 
			   
			 /* Result Set , Print */	
				qry = " Insert into people(id, name, age) "
					 +" values (? , ?, to_number(?))";
			   
				log.info(qry);
				
				intI = template.update(qry,vo_People.getId(), vo_People.getName(), vo_People.getAge());
				
		   }catch (Exception e) {
			    intI = 1;
				System.out.println("Error =>"+e);			
			}finally {			
			}	
		 
		 log.info("doCreate"); 
		 
		return intI;
	}

	/* ID 를 수정하는 메서드 */
	public int doUpdate(Vo_People vo_People) {
		
		String qry="";
				
		int intI =0;
				
		 try{ 
			   
			 /* Result Set , Print */	
				qry = " update people "
					 +" SET "
					 +" name =?, age =? "
					 +" WHERE id = ?"
					 ;					 
			     
				log.info(qry);
				
				intI = template.update(qry, vo_People.getName(), vo_People.getAge(), vo_People.getId());
				
		   }catch (Exception e) {
			    intI = 1;
				System.out.println("Error =>"+e);			
			 }finally {				
			}	
		 
		 log.info("doCreate"); 
		 
		return intI;
	}

	/* ID 를 삭제하는 메서드 */
	public int doDelete(String id) {
		
		String qry="";
		
		int intI =0;		
				
		 try{ 
			   
			 /* Result Set , Print */	
				qry = " Delete from people "
					 +" WHERE id = ?"
					 ;					 
			     
				log.info(qry);
				
				intI = template.update(qry, id);
				
		   }catch (Exception e) {
			    intI = 1;
				System.out.println("Error =>"+e);			
			 }finally {				
			}	
		 
		 log.info("doCreate"); 
		 
		return intI;
		
	}

}
