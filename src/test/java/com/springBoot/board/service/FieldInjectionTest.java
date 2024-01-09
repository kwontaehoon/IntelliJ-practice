package com.springBoot.board.service;

import com.springBoot.board.controller.dto.MemberDTO;
import com.springBoot.board.controller.dto.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FieldInjectionTest {

    @Autowired
    private Student student;

    @Test
    public void test () {
        System.out.println("Field Injection: " + student);
    }
}
