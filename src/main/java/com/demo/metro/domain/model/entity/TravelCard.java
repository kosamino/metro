/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TravelCard
 * Author:   houjing
 * Date:     2019/5/19 15:59
 * Description: travel card info
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.domain.model.entity;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈travel card info〉
 *
 * @author houjing
 * @create 2019/5/19
 * @since 1.0.0
 */
@SuppressWarnings("serial")
public class TravelCard implements Serializable {

    private long travelCardNo;
    private long passengerId;
    private long remainder;

    public long getTravelCardNo() {
        return travelCardNo;
    }

    public void setTravelCardNo(long travelCardNo) {
        this.travelCardNo = travelCardNo;
    }

    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }

    public long getRemainder() {
        return remainder;
    }

    public void setRemainder(long remainder) {
        this.remainder = remainder;
    }

    @Override
    public String toString() {
        return "TravelCard [travelCardNo=" + travelCardNo + ", passengerId=" + passengerId + ", remainder=" + remainder + "]";
    }

}