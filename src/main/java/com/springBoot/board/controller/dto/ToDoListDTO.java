package com.springBoot.board.controller.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
public class ToDoListDTO {

    private Integer id;

    private String userId;

    private String title;

    private LocalDateTime date;

    private Boolean finish;
}
