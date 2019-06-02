/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MetroStation
 * Author:   houjing
 * Date:     2019/5/19 15:34
 * Description: metro  station point
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.domain.model.entity;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈metro  station point〉
 *
 * @author houjing
 * @create 2019/5/19
 * @since 1.0.0
 */
@SuppressWarnings("serial")
public class MetroStation implements Serializable {

    private long stationNo;
    private String stationName;
    private String stationDesc;


    public long getStationNo() {
        return stationNo;
    }

    public void setStationNo(long stationNo) {
        this.stationNo = stationNo;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationDesc() {
        return stationDesc;
    }

    public void setStationDesc(String stationDesc) {
        this.stationDesc = stationDesc;
    }

    @Override
    public String toString() {
        return "MetroStation [stationNo=" + stationNo + ", stationName=" + stationName + ", stationDesc="  + stationDesc + "]";
    }
}