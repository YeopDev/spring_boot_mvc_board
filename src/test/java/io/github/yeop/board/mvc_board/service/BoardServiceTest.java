package io.github.yeop.board.mvc_board.service;

import io.github.yeop.board.mvc_board.dto.BoardListDto;
import io.github.yeop.board.mvc_board.dto.InsertBoardDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BoardServiceTest {
    BoardService boardService;

    @Test
    void selectBoardList() {
        //given
        boardService.insertBoard(new InsertBoardDto("boardA", "content"));

        //when
        List<BoardListDto> findBoardList = boardService.selectBoardList();

        //then
        assertThat(findBoardList).hasSize(1);
    }
}