/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PassengerServiceImpl
 * Author:   houjing
 * Date:     2019/5/16 00:59
 * Description: passenger service implication
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.metro.service.impl;

import com.demo.metro.domain.model.dao.PassengerDAO;
import com.demo.metro.domain.model.entity.Passenger;
import com.demo.metro.service.PassengerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈passenger service implication〉
 *
 * @author houjing
 * @create 2019/5/16
 * @since 1.0.0
 */
@Service
public class PassengerServiceImpl implements PassengerService {

    @Resource
    private PassengerDAO passengerDAO;

    @Override
    public List<Passenger> findAll() {
        return this.passengerDAO.findAll();
    }

    @Override
    public Passenger findById(long passengerId) {
//        return this.passengerDAO.findById(passengerId);
        return this.passengerDAO.queryById(passengerId);
    }

    @Override
    @Transactional
//    @Transactional(noRollbackFor=RuntimeException.class)    //不回滚
//    @Transactional(propagation = Propagation.REQUIRED, timeout = 1)
    public long insertOne(Passenger passenger) {
        this.passengerDAO.insertOne(passenger);
        //@Transactional(noRollbackFor=RuntimeException.class)    //不回滚
        if (true) {
            throw new RuntimeException("save 抛异常了");
        }
        return passenger.getPassengerId();
    }

    @Override
    public void updateById(Passenger passenger) {
        this.passengerDAO.updateById(passenger);
    }

    @Override
    public void deleteById(long passengerId) {
        this.passengerDAO.deleteById(passengerId);
    }
}