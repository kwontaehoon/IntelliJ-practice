package com.springBoot.board.service;

import com.springBoot.board.controller.dto.MessageDTO;
import com.springBoot.board.controller.dto.ToDoListDTO;
import com.springBoot.board.domain.ToDoList;
import com.springBoot.board.repository.ToDoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

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

        Optional<ToDoList> storedList = toDoListRepository.findById(toDoListDTO.getId());

        if(storedList.isPresent()) {

            ToDoList updateList = storedList.get();
            updateList.setTitle(toDoListDTO.getTitle());

            toDoListRepository.save(updateList);
        }

        return ResponseEntity.ok().body(messageDTO);
    }

    /**
     * test
     *
     * @params
     * @return
     **/

    public Integer mapperTest (Integer id) {
        return 123;
    }
}
