package com.springBoot.board.controller.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MessageDTO {

    private String status;

    private String message;

    private Object data;

    private String token;
}
