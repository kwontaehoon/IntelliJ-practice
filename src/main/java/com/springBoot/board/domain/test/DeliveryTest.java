package com.springBoot.board.domain.test;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class DeliveryTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deliveryId;

    @OneToOne(mappedBy = "deliveryTest")
    private OrderTest orderTest;

    private String city;

    private String street;

    private String zipcode;

    private String status;
}
