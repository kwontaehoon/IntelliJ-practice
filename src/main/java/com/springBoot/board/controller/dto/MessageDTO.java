package com.springBoot.board.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@RequiredArgsConstructor
public class MessageDTO {

    private String status;

    private String message;

    private Object data;
}
