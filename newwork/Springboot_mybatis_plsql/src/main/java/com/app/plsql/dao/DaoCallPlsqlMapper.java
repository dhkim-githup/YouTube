package com.app.plsql.dao;

import org.apache.ibatis.annotations.Mapper;


import java.util.Map;

/**
 * @author
 * Mybatis xml 을 호출하는 매퍼 인터페이스
 * xml - mybatis/mapper/mapper_plsql.xml
 */
@Mapper
public interface DaoCallPlsqlMapper {

   // Transaction
   public void doCallPlsql(Map<String, String> param) ;

   // Transaction
   public void doCallPlsql2(Map<String, String> param) ;

   // Batch
   public void doCallPlsql_PR_BATCH() ;

   // Log 입력
   public int doInsert();

   // Log 삭제 - 오류발생
   public int doDelete();
}
