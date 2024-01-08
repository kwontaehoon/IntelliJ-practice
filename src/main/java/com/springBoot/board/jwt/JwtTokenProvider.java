package com.springBoot.board.jwt;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import java.util.Base64;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.List;

@Component
public class JwtTokenProvider {

    private String secretKey = "";

    private UserDetailsService userDetailsService;

    private long tokenValidTime = 1000L * 60 * 60 * 24 * 30;

    @PostConstruct // 객체 초기화, secretKey를 Base64로 인코딩
    protected void init () {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

     // 토큰 생성
     public String createToken(String userPk, List<String> roles) {
        Claims claims = Jwts.claims().setSubject(userPk); // user를 식별하는 값 들어감
        claims.put("roles", roles); // 정보는 key / value 쌍으로 저장
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims) // 정보 저장
                .setIssuedAt(now) // 토큰 발행 시간 정보
                .setExpiration(new Date(now.getTime() + tokenValidTime))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
     }

     // 토큰에서 회원 정보 추출
     public Authentication getAuthentication(String token) {
         UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));
         return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
     }

     // Request의 Header에서 token 값을 가져온다.
     public String resolveToken(HttpServletRequest request) {
        return request.getHeader("Authorization");
     }

     // 토큰의 유효성 + 만료일자 확인
     public boolean validateToken(String jwtToken) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).build().parseClaimsJws(jwtToken);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
     }

}
