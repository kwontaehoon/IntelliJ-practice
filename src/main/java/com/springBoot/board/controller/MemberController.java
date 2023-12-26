package com.springBoot.board.controller;

import com.springBoot.board.controller.dto.MemberDTO;
import com.springBoot.board.controller.dto.MessageDTO;
import com.springBoot.board.controller.dto.ToDoListDTO;
import com.springBoot.board.domain.Member;
import com.springBoot.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/hello")
    public String getHello() {
        return "Hello Around Hub Studio";
    }

    @PostMapping("/join")
    public String join(Member member) {
        return "string";
    }

    @PostMapping("/test")
    public ResponseEntity<MessageDTO> test (@RequestBody MemberDTO memberDTO) {
        return memberService.signup(memberDTO);
    }

    /**
     * 회원가입
     *
     * @params memberDTO
     * @return responseEntity
     **/
    @PostMapping("/signup")
    public MemberDTO signup (@RequestBody MemberDTO memberDTO) {
        memberService.signup(memberDTO);
        return memberDTO;
    }

    /**
     * 아이디 찾기
     *
     * @params id
     * @return responseEntity
     **/
    @GetMapping("/id")
    public String idCheck (@RequestParam Integer id) {
        memberService.idCheck(id);
        return "";
    }

}
