package com.demo.metro.service;

import com.demo.metro.domain.model.entity.Passenger;

import java.util.List;

public interface PassengerService {

    List<Passenger> findAll();

    Passenger findById(long passengerId);

    long insertOne(Passenger passenger);

    void updateById(Passenger passenger);

    void deleteById(long passengerId);
}