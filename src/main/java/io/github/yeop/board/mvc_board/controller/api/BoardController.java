package io.github.yeop.board.mvc_board.controller.api;

import io.github.yeop.board.mvc_board.dto.BoardDto;
import io.github.yeop.board.mvc_board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/yeop")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/board")
    public String insertBoard(@RequestBody BoardDto board) {
        boardService.insertBoard(board);

        return "redirect:/yeop/board-list";
    }

    @PutMapping(value = "/board")
    public String updateBoard(@RequestBody BoardDto board) {
        boardService.updateBoard(board);

        return "redirect:/yeop/board-list";
    }

    @DeleteMapping("/board/{id}")
    public String deleteBoard(@PathVariable int id) {
        boardService.deleteBoard(id);

        return "redirect:/yeop/board-list";
    }
}
