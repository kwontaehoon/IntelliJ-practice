package com.springBoot.board.controller.dto;

import lombok.Data;

@Data
public class MessageDTO {

    private String status;

    private String message;

    private Object data;
}
