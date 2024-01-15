package com.springBoot.board.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.springBoot.board.controller.dto.ToDoListDTO;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.JSONParser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import java.util.Base64;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;
import org.json.simple.JSONObject;

import java.util.Date;

@Component
public class JwtTokenProvider {

    private String secretKey = "hahahahahahahahahahahahahahahahaha123ahaha";

    private UserDetailsService userDetailsService;

    private long tokenValidTime = 1000L * 60 * 60 * 24 * 30;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

     // 토큰 생성
     public String createToken(Integer userPk, String subject) {
         Claims claims = (Claims) Jwts.claims().setSubject(subject); // user를 식별하는 값 들어감
         claims.put("id", userPk); // 정보는 key / value 쌍으로 저장
         claims.put("userId", subject);
         Date now = new Date();

        return Jwts.builder()
                .setSubject("authorization") // 토큰 사용 용도
                .setClaims(claims) // 정보 저장
                .setIssuedAt(now) // 토큰 발행 시간 정보
                .setExpiration(new Date(now.getTime() + tokenValidTime))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact(); // 토큰 생성
     }

    // 토큰에서 사용자 식별 정보 조회
    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    // 토큰 복호화
    public static String base64UrlDecode(String input) {
        // '+'를 '-'로, '/'를 '_'로 치환
        String base64 = input.replace('-', '+').replace('_', '/');

        // Base64 디코딩
        byte[] decodedBytes = Base64.getDecoder().decode(base64);
        return new String(decodedBytes);
    }

    // 토큰 header / payload / signature 나누기
    public String getUserPk(String token) {
        if(token == null){
            return null;
        }else{
            token = token.replace("Bearer ", "");

            // JWT 토큰은 '.'으로 구분된 세 부분으로 구성되어 있음
            String[] parts = token.split("\\.");
            // payload 부분은 두 번째 부분
            String payload = parts.length > 1 ? parts[1] : "";
            try {

            ObjectMapper mapper = new ObjectMapper();

                JsonNode node = mapper.readTree(base64UrlDecode(payload));
                return node.get("userId").asText();
            } catch (JsonProcessingException e) {
                return base64UrlDecode(payload);
            }
        }
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    // 토큰 유효성 검사
    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    // 토큰 만료 여부 확인
    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getExpiration();
        return expiration.before(new Date());
    }
}
