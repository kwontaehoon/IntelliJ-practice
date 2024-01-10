package com.springBoot.board.service;

import com.springBoot.board.controller.dto.MessageDTO;
import com.springBoot.board.controller.dto.ToDoListDTO;
import com.springBoot.board.domain.ToDoList;
import com.springBoot.board.repository.ToDoListRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TodoListService {

    @Autowired
    private final ToDoListRepository toDoListRepository;

    @Autowired
    private final MessageDTO messageDTO;

    /**
     * 리스트
     *
     * @params toDoListDTO
     * @return List
     **/
    public List<ToDoList> list () {
        return toDoListRepository.findAll();
    }

    /**
     * 글 생성
     *
     * @params toDoListDTO
     * @return responseEntity
     **/
    public ResponseEntity<MessageDTO> toDoWrite (ToDoListDTO toDoListDTO) {

        ToDoList toDoList = ToDoList.builder()
                .title(toDoListDTO.getTitle())
                .date(LocalDateTime.now())
                .build();
        toDoListRepository.save(toDoList);

        return ResponseEntity.ok().body(messageDTO);
    }

    /**
     * 글 삭제
     *
     * @params toDoListDTO
     * @return responseEntity
     **/
    public ResponseEntity<MessageDTO> toDoDelete (ToDoListDTO toDoListDTO) {
        System.out.println("aa: " + toDoListDTO);
        toDoListRepository.deleteById(toDoListDTO.getId());
        return ResponseEntity.ok().body(messageDTO);
    }

    /**
     * 글 수정
     *
     * @params toDoListDTO
     * @return responseEntity
     **/
    public ResponseEntity<MessageDTO> toDoModify (ToDoListDTO toDoListDTO) {

        return ResponseEntity.ok().body(messageDTO);
    }
}
