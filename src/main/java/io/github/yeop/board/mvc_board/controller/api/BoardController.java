package io.github.yeop.board.mvc_board.controller.api;

import io.github.yeop.board.mvc_board.dto.BoardDto;
import io.github.yeop.board.mvc_board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/yeop")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/board")
    public ResponseEntity<String> insertBoard(@RequestBody BoardDto board) {
        boardService.insertBoard(board);
        log.debug("insert Board");

        return ResponseEntity.ok("insert success");
    }

    @PutMapping(value = "/board")
    public ResponseEntity<String> updateBoard(@RequestBody BoardDto board) {
        boardService.updateBoard(board);
        log.debug("update Board");

        return ResponseEntity.ok("update success");
    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable int id) {
        boardService.deleteBoard(id);
        log.debug("delete Board");

        return ResponseEntity.ok("delete success");
    }
}
