package com.springBoot.board.controller;

import com.springBoot.board.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoListController {

    @Autowired
    private TodoListService todoListService;

}
