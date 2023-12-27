package com.springBoot.board.service;

import com.springBoot.board.repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoListService {

    @Autowired
    private ToDoListRepository toDoListRepository;

}
