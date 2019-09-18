/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: OnewayCard
 * Author:   houjing
 * Date:     2019/5/19 16:09
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author houjing
 * @create 2019/5/19
 * @since 1.0.0
 */
@SuppressWarnings("serial")
public class OnewayCard implements Serializable {

    private long onewayCardNo;
    private long passengerId;
    private long amount;
    private int usageFlag;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp purchaseTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp expireTime;

    public long getOnewayCardNo() {
        return onewayCardNo;
    }

    public void setOnewayCardNo(long onewayCardNo) {
        this.onewayCardNo = onewayCardNo;
    }

    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public int getUsageFlag() {
        return usageFlag;
    }

    public void setUsageFlag(int usageFlag) {
        this.usageFlag = usageFlag;
    }

    public Timestamp getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Timestamp purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Timestamp getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Timestamp expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public String toString() {
        return "OnewayCard [onewayCardNo=" + onewayCardNo + ", passengerId=" + passengerId + ", amount=" + amount
                + ", usageFlag=" + usageFlag + ", purchaseTime=" + purchaseTime +  ", expireTime=" + expireTime + "]";
    }

}