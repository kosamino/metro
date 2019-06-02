/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: FeesRecordDAO
 * Author:   houjing
 * Date:     2019/5/16 00:50
 * Description: passenger dao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.domain.model.dao;

import com.demo.metro.domain.model.entity.FeesRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈FeesRecord dao〉
 *
 * @author houjing
 * @create 2019/5/16
 * @since 1.0.0
 */
@Mapper
public interface FeesRecordDAO {

    List<FeesRecord> findAll();

    FeesRecord findById(long feesId);

    void insertOne(FeesRecord feesRecord);

    void updateById(FeesRecord feesRecord);

    void deleteById(long feesId);
}
