package com.springBoot.board.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(nullable = false)
    private String itemId;

    @Column(nullable = false)
    private Integer itemCount;

    @Column(nullable = false)
    private String itemName;

    @Column(nullable = false)
    private String userId;
}
