package com.springBoot.board.controller.dto;

import lombok.Data;

@Data
public class ToDoListDTO {

    private Integer id;

    private String password;

    private String name;

    private String email;
}
