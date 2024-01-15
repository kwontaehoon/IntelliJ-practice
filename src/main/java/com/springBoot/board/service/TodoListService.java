package com.springBoot.board.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springBoot.board.controller.dto.MessageDTO;
import com.springBoot.board.controller.dto.ToDoListDTO;
import com.springBoot.board.domain.Member;
import com.springBoot.board.domain.ToDoList;
import com.springBoot.board.mapper.ListMapper;
import com.springBoot.board.repository.ToDoListRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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

    @Autowired
    private  final ListMapper listMapper;

    /**
     * 리스트
     *
     * @params toDoListDTO
     * @return List
     **/
    public ResponseEntity<MessageDTO> list (String userId) {

        if(userId == null){
            messageDTO.setData(toDoListRepository.findAll());
        }else{
            messageDTO.setData(toDoListRepository.findByUserId(userId));
        }
        return ResponseEntity.ok().body(messageDTO);
    }

    /**
     * 글 작성
     *
     * @params toDoListDTO
     * @return responseEntity
     **/
    public ResponseEntity<MessageDTO> toDoWrite (ToDoListDTO toDoListDTO, String userId) {

        ToDoList toDoList = ToDoList.builder()
                .title(toDoListDTO.getTitle())
                .date(LocalDateTime.now())
                .userId(userId)
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

    public ResponseEntity<MessageDTO> mapperTest () {
        Optional<Member> storedMember = listMapper.getUserId(2);
        System.out.println("test: " + storedMember);
        messageDTO.setData(storedMember);
        return ResponseEntity.ok().body(messageDTO);
    }
}
