package com.springBoot.board.controller;

import com.springBoot.board.entity.Board;
import com.springBoot.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") // localhost:8080 /board/write
    public String boardWriteForm() {

        return "boardWrite";
    }

    @GetMapping("board/list")
    public String boardList(Model model) {

        model.addAttribute("list", boardService.boardList());

        return "boardList";
    }

    @GetMapping("board/view")
    public String boardView(Model model, @RequestParam(name = "id") Integer id) {

        model.addAttribute("board", boardService.boardView(id));
        return "boardView";
    }

    @PostMapping("/board/writePro")
    public String boardWritePro(Board board) {

        boardService.write(board);
        return "test";
    }
}
