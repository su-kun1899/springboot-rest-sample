package com.higedrum.springboot.rest.sample.api;

import com.higedrum.springboot.rest.sample.domain.Customer;
import com.higedrum.springboot.rest.sample.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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
     * curl http://localhost:8080/api/customers/ -v -X GET
     *
     * @return 顧客全件取得
     */
    @RequestMapping(method = RequestMethod.GET)
    List<Customer> getCustomers() {
        List<Customer> customers = customerService.findAll();
        return customers;
    }

    /**
     * curl http://localhost:8080/api/customers/129 -v -X GET
     *
     * @param id 顧客ID
     * @return 顧客一件取得
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Customer getCustomer(@PathVariable Integer id) {
        Customer customer = customerService.findOne(id);
        return customer;
    }

//    /**
//     * @param customer 顧客
//     * @return 顧客１件登録
//     */
//    @RequestMapping(method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    Customer postCustomers(@RequestBody Customer customer) {
//        return customerService.create(customer);
//    }

    /**
     * レスポンスヘッダに作成した顧客のlocationを付与して返却する
     * <p>curl http://localhost:8080/api/customers/ -v -X POST -H "Content-Type: application/json" -d "{\"firstName\" : \"Taro\", \"lastName\" : \"Yamada\"}"</p>
     *
     * @param customer 顧客
     * @return 顧客１件登録
     */
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<Customer> postCustomers(@RequestBody Customer customer, UriComponentsBuilder uriComponentsBuilder) {
        Customer created = customerService.create(customer);
        URI location = uriComponentsBuilder.path("api/customers/{id}").buildAndExpand(created.getId()).toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);
        return new ResponseEntity<>(created, headers, HttpStatus.CREATED);
    }

    /**
     * @param id       顧客Id
     * @param customer 顧客
     * @return 顧客１件更新
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    Customer putCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        customer.setId(id);
        return customerService.update(customer);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCustomer(@PathVariable Integer id) {
        customerService.delete(id);
    }
}
