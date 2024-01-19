package com.springBoot.board.controller.dto;

import com.springBoot.board.domain.Member;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class OrdersDTO {

    private Integer orderId;

    private String itemId;

    private Integer itemCount;

    private String itemName;

    private Member member;
}
