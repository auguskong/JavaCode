package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService;
    @Test
    public void getSeckillList() {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}", list);
        //Closing non transactional SqlSession
    }

    @Test
    public void getById() {
        long id = 1000;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}",seckill);
    }

    @Test
    public void exportSeckillUrl() {
        long id = 1004;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        logger.info("exposer={}",exposer);
    }
    /**
     * {exposed=true, md5='508ab371174d39ad58c4fa6fd7199e39', seckillId=1004, now=0, start=0, end=0}
     */

    //自定义一个用于测试代码完整逻辑的代码，注意可重复执行
    @Test
    public void testSeckillLogic() {
        long id = 1000;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()) {
            logger.info("exposer={}",exposer);
            long phone = 12343232331L;
            // 将Md5的生成和使用集合到一起
            String md5 = exposer.getMd5();
            // 定义两个可允许的异常: 1.重复秒杀 和 2.秒杀已关闭异常 只提出警告而不认为属于测试失败
            try {
                SeckillExecution execution = seckillService.executeSeckill(id, phone, md5);
                logger.info("result={}", execution);
            } catch (RepeatKillException e) {
                logger.error(e.getMessage());
            } catch (SeckillCloseException e) {
                logger.error(e.getMessage());
            }
        } else {
            // 秒杀未开启
            logger.warn("exposer={}",exposer);
        }
    }

    /**
     * 11:21:44.427 [main] DEBUG org.mybatis.spring.SqlSessionUtils - Creating a new SqlSession
     11:21:44.435 [main] DEBUG org.mybatis.spring.SqlSessionUtils - Registering transaction synchronization for SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@30b6ffe0]
     11:21:44.445 [main] DEBUG o.m.s.t.SpringManagedTransaction - JDBC Connection [com.mchange.v2.c3p0.impl.NewProxyConnection@6f3187b0] will be managed by Spring
     11:21:44.452 [main] DEBUG o.s.dao.SeckillDao.reduceNumber - ==>  Preparing: UPDATE seckill SET number = number - 1 WHERE seckill_id = ? AND start_time <= ? And end_time >= ? AND number > 0;
     11:21:44.542 [main] DEBUG o.s.dao.SeckillDao.reduceNumber - ==> Parameters: 1004(Long), 2018-11-09 11:21:44.413(Timestamp), 2018-11-09 11:21:44.413(Timestamp)
     11:21:44.572 [main] DEBUG o.s.dao.SeckillDao.reduceNumber - <==    Updates: 1
     11:21:44.572 [main] DEBUG org.mybatis.spring.SqlSessionUtils - Releasing transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@30b6ffe0]
     11:21:44.573 [main] DEBUG org.mybatis.spring.SqlSessionUtils - Fetched SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@30b6ffe0] from current transaction
     11:21:44.573 [main] DEBUG o.s.d.S.insertSuccessKilled - ==>  Preparing: INSERT ignore INTO success_killed(seckill_id,user_phone, state, create_time) VALUES (?,?,0,'2018-10-21 03:00:00')
     11:21:44.576 [main] DEBUG o.s.d.S.insertSuccessKilled - ==> Parameters: 1004(Long), 12343232321(Long)
     11:21:44.584 [main] DEBUG o.s.d.S.insertSuccessKilled - <==    Updates: 1
     11:21:44.611 [main] DEBUG org.mybatis.spring.SqlSessionUtils - Releasing transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@30b6ffe0]
     11:21:44.612 [main] DEBUG org.mybatis.spring.SqlSessionUtils - Fetched SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@30b6ffe0] from current transaction
     11:21:44.613 [main] DEBUG o.s.d.S.queryByIdWithSeckill - ==>  Preparing: SELECT sk.seckill_id, sk.user_phone, sk.create_time, sk.state, s.seckill_id "seckill.seckill_id", s.name "seckill.name", s.number "seckill.number", s.start_time "seckill.start_time", s.end_time "seckill.end_time", s.create_time "seckill.create_time" FROM success_killed sk INNER JOIN seckill s ON sk.seckill_id=s.seckill_id WHERE sk.seckill_id=? and sk.user_phone=?
     11:21:44.614 [main] DEBUG o.s.d.S.queryByIdWithSeckill - ==> Parameters: 1004(Long), 12343232321(Long)
     11:21:44.645 [main] DEBUG o.s.d.S.queryByIdWithSeckill - <==      Total: 1
     11:21:44.668 [main] DEBUG org.mybatis.spring.SqlSessionUtils - Releasing transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@30b6ffe0]
     11:21:44.671 [main] DEBUG org.mybatis.spring.SqlSessionUtils - Transaction synchronization committing SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@30b6ffe0]
     11:21:44.675 [main] DEBUG org.mybatis.spring.SqlSessionUtils - Transaction synchronization deregistering SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@30b6ffe0]
     11:21:44.675 [main] DEBUG org.mybatis.spring.SqlSessionUtils - Transaction synchronization closing SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@30b6ffe0]
     11:21:44.697 [main] INFO  o.seckill.service.SeckillServiceTest - result=org.seckill.dto.SeckillExecution@518caac3
     */
}