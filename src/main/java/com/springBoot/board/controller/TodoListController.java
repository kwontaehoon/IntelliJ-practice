package com.springBoot.board.controller;

import com.springBoot.board.controller.dto.MessageDTO;
import com.springBoot.board.controller.dto.ToDoListDTO;
import com.springBoot.board.domain.ToDoList;
import com.springBoot.board.service.TodoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoListController {

    @Autowired
    private final TodoListService todoListService;

    // 리스트
    @GetMapping("/list")
    public List<ToDoList> list () {
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
}
