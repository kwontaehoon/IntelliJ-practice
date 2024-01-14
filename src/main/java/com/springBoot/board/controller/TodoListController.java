package com.springBoot.board.controller;

import com.springBoot.board.controller.dto.MessageDTO;
import com.springBoot.board.controller.dto.ToDoListDTO;
import com.springBoot.board.domain.ToDoList;
import com.springBoot.board.jwt.JwtTokenProvider;
import com.springBoot.board.service.TodoListService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoListController {

    @Autowired
    private final TodoListService todoListService;

    @Autowired
    private final JwtTokenProvider jwtTokenProvider;

    public static String base64UrlDecode(String input) {
        String base64 = input.replace('-', '+').replace('_', '/');
        byte[] decodedBytes = Base64.getDecoder().decode(base64);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }

    // 리스트
    @GetMapping("/list")
    public List<ToDoList> list (@RequestHeader("Authorization") String token, HttpServletRequest request) {
        System.out.println("token: " + token);
        String userId = jwtTokenProvider.resolveToken(request);
        System.out.println("userId: " + userId);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        System.out.println("aaaaaaaaaaaaaa: "+base64UrlDecode(userId));

        return todoListService.list();
    }

    // 글 작성
    @PostMapping("/write")
    public ResponseEntity<MessageDTO> toDoWrite (@RequestBody ToDoListDTO toDoListDTO) {
        return todoListService.toDoWrite(toDoListDTO);
    }

    // 글 삭제
    @PostMapping("/delete")
    public ResponseEntity<MessageDTO> toDoDelete (@RequestBody ToDoListDTO toDoListDTO) {
        return todoListService.toDoDelete(toDoListDTO);
    }

    // 글 수정
    @PostMapping("/modify")
    public ResponseEntity<MessageDTO> toDoModify (@RequestBody ToDoListDTO toDoListDTO) {
        return todoListService.toDoModify(toDoListDTO);
    }

    // mapper 테스트
    @PostMapping("/mapperTest")
    public Integer mapperTest (@RequestBody Integer id) {
        return todoListService.mapperTest(id);
    }
}
