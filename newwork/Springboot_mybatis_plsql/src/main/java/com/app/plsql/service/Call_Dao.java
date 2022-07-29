package com.app.plsql.service;

import com.app.plsql.dao.DaoCallPlsqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class Call_Dao {

    @Autowired
    DaoCallPlsqlMapper daoCallPlsqlMapper;

    public void doCallPlSql() {


        Map<String, String> hm = new HashMap<String, String>();

        try {

            hm.put("pCST_ID", "C005");

            System.out.println("Break == 1 |>> " + daoCallPlsqlMapper);

            daoCallPlsqlMapper.doCallPlsql_PR_BATCH();

            /*
            daoCallPlsqlMapper.doCallPlsql2(hm);
            System.out.println("Break == 2");
            String strRCode = hm.get("rRtn");
            String strRMsg = hm.get("rMsg");

            System.out.printf("r_code %s  | r_msg %s \n", strRCode, strRMsg);

            if ("NO".equals(strRCode)) {
                throw new Exception();
            }
            */


        }catch (Exception e){
            System.out.println("Error =>"+e.getMessage());
            throw new RuntimeException();
        }

    }
}
