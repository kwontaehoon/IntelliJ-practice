package com.springBoot.board.controller.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class MemberDTO {

    private Integer memberId;

    private String userId;

    private String password;

    private String name;

    private String email;
}
