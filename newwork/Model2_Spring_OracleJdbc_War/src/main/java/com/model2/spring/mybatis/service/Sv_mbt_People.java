package com.model2.spring.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model2.spring.mybatis.dao.Dao_If_People;
import com.model2.spring.vo.Vo_People;

@Service
@Transactional
public class Sv_mbt_People implements Sv_mbt_IfPeople {
	
	Dao_If_People dao_People;
	
	@Autowired
	public Sv_mbt_People(Dao_If_People dao_People) {
		this.dao_People = dao_People;
	}

	/* People 의 값을 전부 가져오는 메서드 */
	@Override
	public List<Vo_People> doReadList() {
		
		List<Vo_People> list = dao_People.doReadList();
		
		return list;
	}

	/* 특정 ID 값을 져오는 메서드 */
	@Override
	public Vo_People doReadId(String id) {
		
	  Vo_People vo_People =null;	
	  
	  /* data 유효성 검증 */
	  if(id != null) {	
		vo_People = dao_People.doReadId(id);
	  }else {
		vo_People = null;  
	  }
	  
		return vo_People;
	}

	/* ID 를 생성하는 메서드 */
	@Override
	public int doCreate(String id, String name, String age) {
		
		int intI = dao_People.doCreate(id, name, age);
		
		return intI;
	}

	/* ID 를 수정하는 메서드 */
	@Override
	public int doUpdate(Vo_People vo_People) {
		
		int intI = dao_People.doUpdate(vo_People);
		
		return intI;
	}

	/* ID 를 삭제하는 메서드 */
	@Override	
	public int doDelete(String id) {

		int intI = dao_People.doDelete(id);
		
		return intI;
	}

}
