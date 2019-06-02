/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Passenger
 * Author:   houjing
 * Date:     2019/5/16 00:47
 * Description: Passenger entity
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.domain.model.entity;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈Passenger entity〉
 *
 * @author houjing
 * @create 2019/5/16
 * @since 1.0.0
 */
@SuppressWarnings("serial")
public class Passenger implements Serializable {

    private long passengerId;
    private String passengerName;
    private String passengerSex;
    private long travelCard;
    private long onewayCard;

    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerSex() {
        return passengerSex;
    }

    public void setPassengerSex(String passengerSex) {
        this.passengerSex = passengerSex;
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

    @Override
    public String toString() {
        return "Passenger [passengerId=" + passengerId + ", passengerName=" + passengerName + ", passengerSex="
                + passengerSex + ", travelCard=" + travelCard + ", onewayCard=" + onewayCard + "]";
    }
}