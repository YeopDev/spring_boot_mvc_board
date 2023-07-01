package io.github.yeop.board.mvc_board.controller.api;

import io.github.yeop.board.mvc_board.dto.InsertBoardDto;
import io.github.yeop.board.mvc_board.dto.UpdateBoardDto;
import io.github.yeop.board.mvc_board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/yeop")
public class BoardController {
    private final BoardService boardService;

    @PostMapping(path = "/board", consumes = {"multipart/form-data"})
    public ResponseEntity<String> insertBoard(@ModelAttribute InsertBoardDto board, @RequestParam(value = "files", required = false) List<MultipartFile> files) throws MultipartException {
        boardService.insertBoard(board, files);
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
