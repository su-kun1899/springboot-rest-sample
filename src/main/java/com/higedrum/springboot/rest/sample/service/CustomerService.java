package com.higedrum.springboot.rest.sample.service;

import com.higedrum.springboot.rest.sample.domain.Customer;
import com.higedrum.springboot.rest.sample.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 顧客用Serviceクラスです
 *
 * Created by koji on 2016/06/07.
 */
@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

}
