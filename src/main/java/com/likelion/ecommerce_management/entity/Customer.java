package com.likelion.ecommerce_management.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "CUSTOMER_ID", nullable = false)
    int customer_id;

    @Column(name = "CUSTOMER_NAME", nullable = false)
    String customer_name;

    @Column(name = "ADDRESS")
    String address;

    @Column(name = "PHONE_NO", nullable = false)
    String phone_no;
}
