package com.springBoot.board.controller;

import com.springBoot.board.controller.dto.MemberDTO;
import com.springBoot.board.controller.dto.MessageDTO;
import com.springBoot.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    @Autowired
    private final MemberService memberService;

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
     * 중복 아이디 확인
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

    /**
     * 아이디 찾기
     *
     * @params
     * @return
     **/
    @PostMapping("/idSearch")
    public ResponseEntity<MessageDTO> idSearch(@RequestBody MemberDTO memberDTO) {
        System.out.println("aaaaaaaaaaaaa: " + memberDTO);
        return memberService.idSearch(memberDTO);
    }

    /**
     * 비밀번호 찾기
     *
     * @params
     * @return
     **/
    @PostMapping("/pwdSearch")
    public ResponseEntity<MessageDTO> pwdSearch(@RequestBody MemberDTO memberDTO) {
        return memberService.pwdSearch(memberDTO);
    }
}
