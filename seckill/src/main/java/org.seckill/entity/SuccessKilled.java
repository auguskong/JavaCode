package org.seckill.entity;

import java.util.Date;

public class SuccessKilled {
    private long seckillId;

    private long userPhone;

    private short statel;

    private Date createTime;

    //变通: 多对一的 复合属性
    private Seckill seckill;


    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public short getStatel() {
        return statel;
    }

    public void setStatel(short statel) {
        this.statel = statel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "SuccessKilled{" +
                "seckillId=" + seckillId +
                ", userPhone=" + userPhone +
                ", statel=" + statel +
                ", createTime=" + createTime +
                '}';
    }
}
