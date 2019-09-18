/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TravelRecord
 * Author:   houjing
 * Date:     2019/5/19 16:34
 * Description: travel   records
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
 * 〈travel   records〉
 *
 * @author houjing
 * @create 2019/5/19
 * @since 1.0.0
 */
@SuppressWarnings("serial")
public class TravelRecord implements Serializable {

    private long travelRecordId;
    private long passengerId;
    private long beginStationId;
    private long finalStationId;
    private long amount;
    private long travelCard;
    private long onewayCard;
    private String travelInfo;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp occurTime;

    public long getTravelRecordId() {
        return travelRecordId;
    }

    public void setTravelRecordId(long travelRecordId) {
        this.travelRecordId = travelRecordId;
    }

    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }

    public long getBeginStationId() {
        return beginStationId;
    }

    public void setBeginStationId(long beginStationId) {
        this.beginStationId = beginStationId;
    }

    public long getFinalStationId() {
        return finalStationId;
    }

    public void setFinalStationId(long finalStationId) {
        this.finalStationId = finalStationId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getTravelCard() {
        return travelCard;
    }

    public void setTravelCard(long travelCard) {
        this.travelCard = travelCard;
    }

    public long getOnewayCard() {
        return onewayCard;
    }

    public void setOnewayCard(long onewayCard) {
        this.onewayCard = onewayCard;
    }

    public String getTravelInfo() {
        return travelInfo;
    }

    public void setTravelInfo(String travelInfo) {
        this.travelInfo = travelInfo;
    }

    public Timestamp getOccurTime() {
        return occurTime;
    }

    public void setOccurTime(Timestamp occurTime) {
        this.occurTime = occurTime;
    }

    @Override
    public String toString() {
        return "TravelRecord [travelRecordId=" + travelRecordId + ", passengerId=" + passengerId + ", beginStationId=" + beginStationId
                + ", finalStationId=" + finalStationId + ", amount=" + amount +  ", travelCard=" + travelCard
                + ", onewayCard=" + onewayCard + ", travelInfo=" + travelInfo +  ", occurTime=" + occurTime + "]";
    }

}