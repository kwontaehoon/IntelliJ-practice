package com.springBoot.board.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrdersDTO {

    private Integer orderId;

    private String itemId;

    private Integer itemCount;

    private String itemName;

    private String userId;
}
