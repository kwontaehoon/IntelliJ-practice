package com.springBoot.board.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean {

    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 헤더에서 JWT를 받아온다.
        String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);
        System.out.println("header token: " + token);

        // 유효한 토큰인지 확인한다.
        if (token != null && jwtTokenProvider.validateToken((token))) {

            // 토큰이 유효하면 토큰으로부터 유저 정보를 받아와서 SecurityContext에 저장
            Authentication authentication = jwtTokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }

//    private String getParseJwt(final String headerAuth) {
//        if(StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer")) {
//            return headerAuth.substring(7);
//        }
//        return null;
//    }
}
