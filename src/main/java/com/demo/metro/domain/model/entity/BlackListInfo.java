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

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 〈一句话功能简述〉<br>
 * 〈the passenger consume black list〉
 *
 * @author houjing
 * @create 2019/5/19
 * @since 1.0.0
 */
@SuppressWarnings("serial")
public class BlackListInfo implements Serializable {

    private long blackRecordId;
    private TravelRecord travelRecord;
    private long travelRecordId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp occurTime;

    public long getBlackRecordId() {
        return blackRecordId;
    }

    public void setBlackRecordId(long blackRecordId) {
        this.blackRecordId = blackRecordId;
    }

    public TravelRecord getTravelRecord() {
        return travelRecord;
    }

    public void setTravelRecord(TravelRecord travelRecord) {
        this.travelRecord = travelRecord;
    }

    public long getTravelRecordId() {
        return travelRecordId;
    }

    public void setTravelRecordId(long travelRecordId) {
        this.travelRecordId = travelRecordId;
    }

    public Timestamp getOccurTime() {
        return occurTime;
    }

    public void setOccurTime(Timestamp occurTime) {
        this.occurTime = occurTime;
    }

    @Override
    public String toString() {
        return "BlackList [blackRecordId=" + blackRecordId + ", travelRecord=" + travelRecord
                + ", travelRecordId=" + travelRecordId + ", occurTime=" + occurTime + "]";
    }
}