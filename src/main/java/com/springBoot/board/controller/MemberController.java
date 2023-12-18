package com.springBoot.board.controller;

import com.springBoot.board.controller.dto.JoinRequest;
import com.springBoot.board.domain.Member;
import com.springBoot.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        memberService.join();
        return "string";
    }

}
