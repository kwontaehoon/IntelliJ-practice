package com.springBoot.board.controller.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class LoginDTO {

    @Id
    private String userId;

    private String password;
}
