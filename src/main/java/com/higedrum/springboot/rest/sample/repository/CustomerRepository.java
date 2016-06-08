package com.higedrum.springboot.rest.sample.repository;

import com.higedrum.springboot.rest.sample.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 顧客用のリポジトリです。
 *
 * Created by koji on 2016/06/07.
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
