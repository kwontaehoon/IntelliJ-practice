package com.springBoot.board.controller;

import com.springBoot.board.controller.dto.MemberDTO;
import com.springBoot.board.controller.dto.MessageDTO;
import com.springBoot.board.controller.dto.ToDoListDTO;
import com.springBoot.board.domain.Member;
import com.springBoot.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<MessageDTO> signup (@RequestBody Member member) {
        System.out.println("MemberDTO: " + member);
        return  memberService.signup(member);
    }

    /**
     * 아이디 찾기
     *
     * @params id
     * @return responseEntity
     **/
    @GetMapping("/id")
    public ResponseEntity<MessageDTO> idCheck (@RequestParam Integer id) {
        return memberService.idCheck(id);
    }

    @GetMapping("/findAll")
    public List<Member> findAll () {
        return memberService.findAll();
    }

}
