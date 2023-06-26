package io.github.yeop.board.mvc_board.controller.ui;

import io.github.yeop.board.mvc_board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/yeop")
@Slf4j
public class IndexController {
    private final BoardService boardService;

    @GetMapping("/board-list")
    public String openBoardList(Model model) {
        model.addAttribute("list", boardService.selectBoardList());

        return "board/boardList";
    }

    @GetMapping("/board-write")
    public String openBoardWrite() {
        return "board/boardWrite";
    }

    @GetMapping("/board-detail/{id}")
    public String openBoardDetail(@PathVariable int id, Model model) {
        model.addAttribute("board", boardService.selectBoardDetail(id));

        return "board/boardDetail";
    }
}
