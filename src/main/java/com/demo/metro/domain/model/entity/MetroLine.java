/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: User
 * Author:   houjing
 * Date:     2019/5/15 00:03
 * Description: entity user
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.domain.model.entity;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈entity user〉
 *
 * @author houjing
 * @create 2019/5/15
 * @since 1.0.0
 */
@SuppressWarnings("serial")
public class MetroLine implements Serializable {

    private long id;
    private int lineNo;
    private long startStation;
    private long endStation;
    private int lineWeight;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLineNo() {
        return lineNo;
    }

    public void setLineNo(int lineNo) {
        this.lineNo = lineNo;
    }

    public long getStartStation() {
        return startStation;
    }

    public void setStartStation(long startStation) {
        this.startStation = startStation;
    }

    public long getEndStation() {
        return endStation;
    }

    public void setEndStation(long endStation) {
        this.endStation = endStation;
    }

    public int getLineWeight() {
        return lineWeight;
    }

    public void setLineWeight(int lineWeight) {
        this.lineWeight = lineWeight;
    }

    @Override
    public String toString() {
        return "MetroLine [id=" + id + ", lineNo=" + lineNo + ", startStation="
                + startStation + ", endStation=" + endStation + ", lineWeight=" + lineWeight + "]";
    }
}