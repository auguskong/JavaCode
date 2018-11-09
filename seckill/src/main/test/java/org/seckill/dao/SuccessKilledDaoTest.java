package org.seckill.dao;

import org.apache.ibatis.annotations.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() {
        long id = 1002L;
        long phone = 14521214569L;
        //System.out.println(successKilledDao);
        int insertCount = successKilledDao.insertSuccessKilled(id, phone);
        System.out.println("insertCount= " + insertCount);
    }

    @Test
    public void queryByIdWithSeckill() {
        long id = 1002L;
        long phone = 14521214569L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id, phone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }
}