package io.github.yeop.board.mvc_board.controller.api;

import io.github.yeop.board.mvc_board.dto.InsertBoardDto;
import io.github.yeop.board.mvc_board.dto.UpdateBoardDto;
import io.github.yeop.board.mvc_board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/yeop")
public class BoardController {
    private final BoardService boardService;

    @PostMapping(path = "/board")
    public ResponseEntity<String> insertBoard(@RequestBody InsertBoardDto board) throws Exception {
        boardService.insertBoard(board);
        return ResponseEntity.ok("insert success");
    }

    @PutMapping(value = "/board")
    public ResponseEntity<String> updateBoard(@RequestBody UpdateBoardDto board) {
        boardService.updateBoard(board);

        return ResponseEntity.ok("update success");
    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable int id) {
        boardService.deleteBoard(id);

        return ResponseEntity.ok("delete success");
    }
}
