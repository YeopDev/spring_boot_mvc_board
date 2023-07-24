package io.github.yeop.board.mvc_board.service;

import io.github.yeop.board.mvc_board.domain.Board;
import io.github.yeop.board.mvc_board.dto.BoardListDto;
import io.github.yeop.board.mvc_board.repository.repositoryMapper.BoardMapperRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BoardServiceTest {

    @Autowired
    BoardService boardService;

    @Autowired
    BoardMapperRepository boardMapperRepository;

    @Test
    void selectBoardList() {
        //given 이러이러한 일
        Board board = new Board(1, "boardA", "content", 1, "userA", LocalDateTime.now(), "userA", LocalDateTime.now());

        //when 이렇게 됐을때
        List<BoardListDto> findBoardList = boardService.selectBoardList();

        //then 이렇게 된다
        assertThat(findBoardList).hasSize(1);
    }

}