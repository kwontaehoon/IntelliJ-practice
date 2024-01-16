package com.springBoot.board.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;
import org.hibernate.type.descriptor.jdbc.TinyIntAsSmallIntJdbcType;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "toDoList")
public class ToDoList {

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
