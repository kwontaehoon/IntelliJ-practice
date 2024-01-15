package com.springBoot.board.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@SpringBootTest
public class Decode {

    public static String base64UrlDecode(String input) {
        String base64 = input.replace('-', '+').replace('_', '/');
        System.out.println("base64: " + base64);
        byte[] decodedBytes = Base64.getDecoder().decode(base64);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }

    @Test
    public void test () {
        var token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJnanUwNDE5NSIsInVzZXJJZCI6ImdqdTA0MTk1IiwiaWF0IjoxNzA1Mjg0MTQzLCJleHAiOjE3MDc4NzYxNDN9.6nWSBkzVeinEbCWRhzKvwfpuOVayfzONzY-ykCTs5pk";
        String[] parts = token.split("\\.");

        // payload 부분은 두 번째 부분
        String payload = parts.length > 1 ? parts[1] : "";
        System.out.println("payload: " + payload);

        System.out.println(base64UrlDecode(payload));
    }
}
