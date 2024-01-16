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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userId;

    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    @Column(columnDefinition = "TINYINT(1)")
    private Boolean finish;
}
