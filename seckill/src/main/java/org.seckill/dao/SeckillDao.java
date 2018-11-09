package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.*;
import java.util.Date;
import java.util.List;


public interface SeckillDao {
    /**
     * 减库存
     *
     * @param seckillId
     * @param killTime
     * @return 表示更新记录行数
     */

    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     * 根据id查询秒杀对象
     *
     * @param seckillId
     * @return
     */

    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     *
     * @param offet 查询偏移的起点
     * @param limit 查询的距离
     * @return
     */

    //使用@Param 注解来告知MyBatis 相关参数的名字
    List<Seckill> queryAll(@Param("offset") int offet, @Param("limit") int limit);
}
