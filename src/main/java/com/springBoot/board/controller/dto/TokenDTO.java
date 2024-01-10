package com.springBoot.board.controller.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class TokenDTO {

    private String status;

    private String grantType;

    private String accessToken;
}
