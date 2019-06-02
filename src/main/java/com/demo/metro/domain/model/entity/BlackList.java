/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BlackList
 * Author:   houjing
 * Date:     2019/5/19 16:51
 * Description: the passenger consume black list
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.domain.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈the passenger consume black list〉
 *
 * @author houjing
 * @create 2019/5/19
 * @since 1.0.0
 */
@SuppressWarnings("serial")
public class BlackList implements Serializable {

    private long blackRecordId;
    private long passengerId;
    private long travelRecordId;
    private Date occurTime;

    public long getBlackRecordId() {
        return blackRecordId;
    }

    public void setBlackRecordId(long blackRecordId) {
        this.blackRecordId = blackRecordId;
    }

    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }

    public long getTravelRecordId() {
        return travelRecordId;
    }

    public void setTravelRecordId(long travelRecordId) {
        this.travelRecordId = travelRecordId;
    }

    public Date getOccurTime() {
        return occurTime;
    }

    public void setOccurTime(Date occurTime) {
        this.occurTime = occurTime;
    }

    @Override
    public String toString() {
        return "BlackList [blackRecordId=" + blackRecordId + ", passengerId=" + passengerId
                + ", travelRecordId=" + travelRecordId + ", occurTime=" + occurTime + "]";
    }
}