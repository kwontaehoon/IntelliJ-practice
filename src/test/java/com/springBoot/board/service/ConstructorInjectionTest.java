package com.springBoot.board.service;

import com.springBoot.board.controller.dto.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConstructorInjectionTest {

    private final Student student;

    @Autowired
    public ConstructorInjectionTest(Student student) {
        this.student = student;
    }

    @Test
    public void test () {
        System.out.println("Constructor Injection: " + student.toString());
    }
}
