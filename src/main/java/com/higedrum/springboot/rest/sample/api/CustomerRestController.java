package com.higedrum.springboot.rest.sample.api;

import com.higedrum.springboot.rest.sample.domain.Customer;
import com.higedrum.springboot.rest.sample.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 顧客Rest Api用のコントローラ
 *
 * Created by koji on 2016/06/08.
 */
@RestController
@RequestMapping("api/customers")
public class CustomerRestController {
    @Autowired
    CustomerService customerService;

    /**
     * @return 顧客全件取得
     */
    @RequestMapping(method = RequestMethod.GET)
    List<Customer> getCustomers() {
        List<Customer> customers = customerService.findAll();
        return customers;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Customer getCustomer(@PathVariable Integer id) {
        Customer customer = customerService.findOne(id);
        return customer;
    }

}
