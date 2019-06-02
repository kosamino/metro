/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MetroDisplayModel
 * Author:   houjing
 * Date:     2019/5/19 23:50
 * Description: metro station display model
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.domain.model.entity;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈metro station display model〉
 *
 * @author houjing
 * @create 2019/5/19
 * @since 1.0.0
 */
@SuppressWarnings("serial")
public class MetroDisplayModel implements Serializable {

    private String startStation;
    private String endStation;
    private int weight;

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "MetroDisplayModel [startStation=" + startStation + ", travelCard=" + endStation + ", endStation=" + weight + ", weight=" + "]";
    }
}