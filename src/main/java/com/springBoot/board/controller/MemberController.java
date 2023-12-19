package com.springBoot.board.controller;

import com.springBoot.board.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @GetMapping("/hello")
    public String getHello() {
        return "Hello Around Hub Studio";
    }

    @PostMapping("/join")
    public String join(Member member) {
        return "string";
    }

}
