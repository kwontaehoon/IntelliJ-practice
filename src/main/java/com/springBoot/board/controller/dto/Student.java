package com.springBoot.board.controller.dto;

import lombok.ToString;

@ToString
public class Student {

    Integer id;
    String name;
    Integer grade;

    public Student(Integer id, String name, Integer grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public static class StudentBuilder {

        Integer id;
        String name;
        Integer grade;

        public StudentBuilder id(Integer id) {
            this.id = id;
            return this;
        }
        public StudentBuilder name(String name) {
            this.name = name;
            return this;
        }
        public StudentBuilder grade(Integer grade) {
            this.grade = grade;
            return this;
        }
        public Student build() {
            return new Student(id, name, grade);
        }
    }

}

