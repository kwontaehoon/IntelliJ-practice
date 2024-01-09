package com.springBoot.board.service;

import com.springBoot.board.controller.dto.MemberDTO;
import com.springBoot.board.controller.dto.Student;
import com.springBoot.board.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SetterInjectionTest {

    private Student student;

    @Autowired
    public void setStudent (Student student) {
        this.student = student;
    }

    @Test
    public void test () {
        System.out.println("Setter Injection test: " + student.toString());
    }
}
