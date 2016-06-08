package com.higedrum.springboot.rest.sample.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 顧客用ドメインオブジェクト
 *
 * Created by koji on 2016/06/07.
 */
@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = true)
    private String firstName;

    @Column(nullable = true)
    private String lastName;

}
