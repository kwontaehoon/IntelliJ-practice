package com.springBoot.board.controller.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@ToString
@Data
@Component
public class Student {

    private Integer id;

    private String name;

    private Integer grade;
}

