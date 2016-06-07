package com.higedrum.springboot.rest.sample.repository;

import com.higedrum.springboot.rest.sample.domain.Customer;
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
@Repository
public class CustomerRepository {

    private final ConcurrentMap<Integer, Customer> customerConcurrentMap = new ConcurrentHashMap<>();

    public List<Customer> findAll() {
        return new ArrayList<>(customerConcurrentMap.values());
    }

    public Customer findOne(Integer customerId) {
        return customerConcurrentMap.get(customerId);
    }

    public Customer save(Customer customer) {
        return customerConcurrentMap.put(customer.getId(), customer);
    }

    public void delete(Integer customerId) {
        customerConcurrentMap.remove(customerId);
    }
}
