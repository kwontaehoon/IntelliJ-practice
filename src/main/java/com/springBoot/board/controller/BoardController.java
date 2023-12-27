package com.springBoot.board.controller;

import com.springBoot.board.controller.dto.BoardDTO;
import com.springBoot.board.domain.Board;
import com.springBoot.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") // localhost:8080/board/write
    public String boardWriteForm() {

        return "boardWrite";
    }

    @GetMapping("/board/list")
    public String boardList(Model model) {
        model.addAttribute("list", boardService.boardList());
        return "boardList";
    }

    @GetMapping("/board/test")
    public String boardTest() {
        return "boardWrite";
    }

    @PostMapping("/board/postTest")
    public BoardDTO boardPostTest(@RequestBody BoardDTO boardDTO) {
        BoardDTO board = new BoardDTO();
//        board.setId(board.getId());
//        board.setTitle(board.getTitle());
//        board.setContent(board.getContent());
        return boardDTO;
    }

    @GetMapping("/board/view")
    public String boardView(Model model, @RequestParam(name = "id") Integer id) {
        model.addAttribute("board", boardService.boardView(id));
        return "boardView";
    }

    @PostMapping("/board/writePro")
    public String boardWritePro(Board board, Model model) {
        System.out.println("Board: " + board);
        boardService.write(board);

        model.addAttribute("message", " 글 작성이 완료되었습니다.");
        model.addAttribute("searchUrl", "/board/list");
        return "boardWrite";
    }

    @GetMapping("/board/delete")
    public String boardDelete(Integer id) {

        boardService.boardDelete(id);

        return "redirect:/board/list";
    }

    @GetMapping("/board/modify")
    public String boardModify(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("board", boardService.boardView(id));
        return "boardModify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, Board board) {
        Board boardTemp = boardService.boardView(id);
//        boardTemp.setTitle(board.getTitle());
//        boardTemp.setContent(board.getContent());

        return "redirect:/board/list";
    }
}
