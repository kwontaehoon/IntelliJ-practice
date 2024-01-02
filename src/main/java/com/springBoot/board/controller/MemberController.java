package com.springBoot.board.controller;

import com.springBoot.board.controller.dto.LoginDTO;
import com.springBoot.board.controller.dto.MemberDTO;
import com.springBoot.board.controller.dto.MessageDTO;
import com.springBoot.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/hello")
    public String getHello() {
        return "Hello Around Hub Studio";
    }

    @PostMapping("/join")
    public String join(MemberDTO memberDTO) {
        return "string";
    }

    /**
     * 회원가입
     *
     * @params memberDTO
     * @return responseEntity
     **/
    @PostMapping("/signup")
    public ResponseEntity<MessageDTO> signup (@RequestBody MemberDTO memberDTO) {
        return  memberService.signup(memberDTO);
    }

    /**
     * 중복 아이디 찾기
     *
     * @params id
     * @return responseEntity
     **/
    @GetMapping("/idCheck")
    public ResponseEntity<MessageDTO> idCheck (@RequestParam String userId) {
        return memberService.idCheck(userId);
    }

    /**
     * 로그인
     * 
     * @params
     * @return 
     **/
    @PostMapping("/login")
    public ResponseEntity<MessageDTO> login (@RequestBody MemberDTO memberDTO) {
        return memberService.login(memberDTO);
    }
}
