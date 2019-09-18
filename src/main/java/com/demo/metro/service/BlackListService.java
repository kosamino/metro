package com.demo.metro.service;

import com.demo.metro.domain.model.entity.BlackListInfo;

import java.util.List;

public interface BlackListService {

    List<BlackListInfo> findAll();
}
