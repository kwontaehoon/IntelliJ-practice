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

    // 리스트
    @GetMapping("/list")
    public ResponseEntity<MessageDTO> list (@RequestHeader(value = "Authorization", required = false) String token, HttpServletRequest request) {
        String userId = jwtTokenProvider.resolveToken(request);
        return todoListService.list(jwtTokenProvider.getUserPk(userId));
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
    @GetMapping("/mapperTest")
    public ResponseEntity<MessageDTO> mapperTest () {
        return todoListService.mapperTest();
    }
}
