package com.higedrum.springboot.rest.sample.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 顧客用ドメインオブジェクト
 *
 * Created by koji on 2016/06/07.
 */
@Data
@AllArgsConstructor
public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
}
