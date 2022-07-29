/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.app.plsql.service;

        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.scheduling.annotation.Scheduled;
        import org.springframework.stereotype.Component;

        import java.text.SimpleDateFormat;
        import java.util.Date;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    Call_Dao call_dao;

    @Autowired
    MybatisTransaction mybatisTransaction;
    /**
     * fixedRate = 5000 : 작업시작으로부터 5초후 -> 이전에 실행된 Task의 시작시간으로 부터 정의된 시간만큼 지난 후 Task를 실행한다.(밀리세컨드 단위)
     * FixedDelay  = 5000 : 작업시간 끝나고부터 5초후 -> 이전에 실행된 Task의 종료시간으로 부터 정의된 시간만큼 지난 후 Task를 실행한다.(밀리세컨드 단위)
     * cron =  CronTab에서의 설정과 같이 cron="0/10 * * * * ?" 과 같은 설정이 가능하고
     * #crontab 1-mm(0~59) , 2-hh(0~24) , 3-day(1~31), 4-mm(1~12) , 5-day of week(0~6)
     *      1) 매월 10일 오전 11시 (0  1  1  10  *  *)
     *      2) 매일 오후 2시 5분 0초 (0  5  14  *  *  *)
     *      3) 10분마다 도는 스케줄러 : 10분 0초, 20분 0초... (0  0/10  *  *  * *)
     *      4) 조건에서만 실행되는 스케줄러 : 10분 0초, 11분 0초 ~ 15분 0초까지 실행 (0  10-15  *  *  *)
     */

    /*
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("[fixedRate] time is now {}", dateFormat.format(new Date()));
    }


    @Scheduled(fixedDelay = 5000)
    public void reportCurrentTimeFixedDelay() {
        log.info("[fixedDelay] time is now {}", dateFormat.format(new Date()));
    }
    */


    @Scheduled(cron="0/10 * * * * *")
    public void reportCurrentTimeCron(){
        log.info("====================================================");
        log.info("====================================================");
        log.info("====================================================");
        log.info("[cron] time is now {}", dateFormat.format(new Date()));
        //call_dao.doCallPlSql();
        mybatisTransaction.doCallTransaction();

    }

}