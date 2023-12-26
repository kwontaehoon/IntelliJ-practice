package com.springBoot.board.controller.dto;

import lombok.Data;

@Data
public class MessageDTO {

    private Integer status;

    private String message;

    private Object data;
}
