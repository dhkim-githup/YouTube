package com.model2.spring.jdbc.service;

import java.util.List;

import com.model2.spring.vo.Vo_People;


public interface Sv_IfPeople {
	
	// 전체 리스트 가져오기 
	public List<Vo_People> doReadList();
	
	// 특정 Id 리스트만 가져오기 
	public Vo_People doReadId(String id);
	
	// 데이타 로우 생성하기
	public int doCreate(Vo_People vo_People);
	
	// 특정 ID 정보 수정하기 
	public int doUpdate(Vo_People vo_People);
	
	// 특정 ID 정보 삭제하기 
	public int doDelete(String id);	

}
