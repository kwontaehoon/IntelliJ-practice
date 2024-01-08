package com.springBoot.board.jwt;

import io.jsonwebtoken.io.Decoders;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private String secretKey = "n21onfosanoafnason@@o1on21n#..ae12";

    private UserDetailsService userDetailsService;

    private long tokenValidTime = 1000L * 60 * 60 * 24 * 30;

    @PostConstruct // 객체 초기화, secretKey를 Base64로 인코딩
    protected void init () {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

     // 토큰 생성
     public String createToken(String userPk, String subject) {
         Claims claims = (Claims) Jwts.claims().setSubject(userPk); // user를 식별하는 값 들어감
         claims.put("userId", userPk); // 정보는 key / value 쌍으로 저장
         claims.put("userName", subject);
         Date now = new Date();

        return Jwts.builder()
                .setClaims(claims) // 정보 저장
                .setIssuedAt(now) // 토큰 발행 시간 정보
                .setExpiration(new Date(now.getTime() + tokenValidTime))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
     }

    // JWT 토큰에서 인증 정보 조회
     public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

     // 토큰엥서 회원 정보 추출
     public String getUserPk(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
     }

     // Request의 Header에서 token 값을 가져온다.
     public String resolveToken(HttpServletRequest request) {
        System.out.println("request: " + request);
        return request.getHeader("Authorization");
     }

     // 토큰의 유효성 + 만료일자 확인
     public boolean validateToken(String token) {
         System.out.println("hi: " + token);
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
     }
}
