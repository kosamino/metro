/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BlackListServiceImpl
 * Author:   houjing
 * Date:     2019/6/14 09:34
 * Description: black list service implements
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.service.impl;

import com.demo.metro.domain.model.dao.BlackListDAO;
import com.demo.metro.domain.model.entity.BlackListInfo;
import com.demo.metro.service.BlackListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈black list service implements〉
 *
 * @author houjing
 * @create 2019/6/14
 * @since 1.0.0
 */
@Service
public class BlackListServiceImpl implements BlackListService {

    @Resource
    private BlackListDAO blackListDAO;

    @Override
    public List<BlackListInfo> findAll() {
        return blackListDAO.queryBlackListInfos();
    }
}