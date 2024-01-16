package com.springBoot.board.controller.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@RequiredArgsConstructor
public class TokenDTO {

    private String status;

    private String grantType;

    private String accessToken;
}
