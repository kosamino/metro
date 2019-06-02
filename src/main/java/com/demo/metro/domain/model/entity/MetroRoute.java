/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MetroRoute
 * Author:   houjing
 * Date:     2019/5/27 01:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.domain.model.entity;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author houjing
 * @create 2019/5/27
 * @since 1.0.0
 */
public class MetroRoute implements Serializable {

    private long routeId;
    private long beginStationId;
    private String beginStationName;
    private long finalStationId;
    private String finalStationName;
    private long amount;
    private String routePlan;

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    public long getBeginStationId() {
        return beginStationId;
    }

    public void setBeginStationId(long beginStationId) {
        this.beginStationId = beginStationId;
    }

    public String getBeginStationName() {
        return beginStationName;
    }

    public void setBeginStationName(String beginStationName) {
        this.beginStationName = beginStationName;
    }

    public long getFinalStationId() {
        return finalStationId;
    }

    public void setFinalStationId(long finalStationId) {
        this.finalStationId = finalStationId;
    }

    public String getFinalStationName() {
        return finalStationName;
    }

    public void setFinalStationName(String finalStationName) {
        this.finalStationName = finalStationName;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getRoutePlan() {
        return routePlan;
    }

    public void setRoutePlan(String routePlan) {
        this.routePlan = routePlan;
    }

    @Override
    public String toString() {
        return "TravelRecord [routeId=" + routeId + ", beginStationId=" + beginStationId + ", beginStationName=" + beginStationName
                + ", finalStationId=" + finalStationId + ", finalStationName=" + finalStationName + ", amount=" + amount
                + ", routePlan=" + routePlan + "]";
    }
}