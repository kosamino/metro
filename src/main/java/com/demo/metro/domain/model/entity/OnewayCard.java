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

import java.io.Serializable;
import java.util.Date;

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
    private Date purchaseTime;
    private Date expireTime;

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

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public String toString() {
        return "OnewayCard [onewayCardNo=" + onewayCardNo + ", passengerId=" + passengerId + ", amount=" + amount
                + ", usageFlag=" + usageFlag + ", purchaseTime=" + purchaseTime +  ", expireTime=" + expireTime + "]";
    }

}