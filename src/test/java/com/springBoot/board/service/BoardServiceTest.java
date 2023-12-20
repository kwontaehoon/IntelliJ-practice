package com.springBoot.board.service;

import com.springBoot.board.controller.dto.BoardDTO;
import com.springBoot.board.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class BoardServiceTest {

    private BoardRepository boardRepository;
    private BoardDTO boardDTO;

    public class Fa {
        private Integer id;
        private String name;

        public Fa(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public boolean ff(Object a, Object b) {
            System.out.println("ababababababababababab: "+ (a == b));
            return a==b;
        }
    }


    @Test
    public void Test() {
        Fa fa = new Fa(1, "aaa");
        Fa fa2 = new Fa(1, "aaa");
        System.out.println("faaaaaaaaaaaaaaaa: "+ fa.equals(fa2));
        int code = fa.hashCode();
        int code2 = fa2.hashCode();
        System.out.println("code: "+code);
        System.out.println("code2: "+code2);
        System.out.println("faaaaaaaaaaaaaaaa: "+ (code == code2));
        System.out.println(fa.ff(fa, fa2));
    }

}