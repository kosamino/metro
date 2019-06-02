/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: FeesRecord
 * Author:   houjing
 * Date:     2019/5/19 16:45
 * Description: the charge or consume info record
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.domain.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈the charge or consume info record〉
 *
 * @author houjing
 * @create 2019/5/19
 * @since 1.0.0
 */
@SuppressWarnings("serial")
public class FeesRecord implements Serializable {

    private long feesId;
    private long travelCard;
    private int operationType;
    private long amount;
    private Date occurTime;

    public long getFeesId() {
        return feesId;
    }

    public void setFeesId(long feesId) {
        this.feesId = feesId;
    }

    public long getTravelCard() {
        return travelCard;
    }

    public void setTravelCard(long travelCard) {
        this.travelCard = travelCard;
    }

    public int getOperationType() {
        return operationType;
    }

    public void setOperationType(int operationType) {
        this.operationType = operationType;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Date getOccurTime() {
        return occurTime;
    }

    public void setOccurTime(Date occurTime) {
        this.occurTime = occurTime;
    }

    @Override
    public String toString() {
        return "FeesRecord [feesId=" + feesId + ", travelCard=" + travelCard + ", operationType=" + operationType
                + ", amount=" + amount + ", occurTime=" + occurTime + "]";
    }
}