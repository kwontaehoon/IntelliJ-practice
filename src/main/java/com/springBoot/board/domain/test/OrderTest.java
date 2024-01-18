package com.springBoot.board.domain.test;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class OrderTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @ManyToOne
    private MemberTest memberId;

    @OneToOne
    @JoinColumn(name = "deliveryId")
    private DeliveryTest deliveryTest;

    @Temporal(TemporalType.TIMESTAMP)
    private String orderDate;

    private String status;
}
