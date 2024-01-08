package com.springBoot.board.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenDTO {

    private String grantType;

    private String accessToken;

    private String refreshToken;
}
