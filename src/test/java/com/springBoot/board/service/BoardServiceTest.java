package com.springBoot.board.service;

import com.springBoot.board.controller.dto.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardServiceTest {

    private final Student student;

    public BoardServiceTest(Student student) {
        this.student = student;
    }

    @Test
    public void aa() {
        // given
        Student bb = new Student.StudentBuilder().id(11123).grade(3).build();
        System.out.println("bb: " + bb.toString());

        // when

        // then


    }


}