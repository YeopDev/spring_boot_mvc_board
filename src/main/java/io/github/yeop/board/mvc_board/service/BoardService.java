package io.github.yeop.board.mvc_board.service;

import io.github.yeop.board.mvc_board.dto.BoardDto;

import java.util.List;

public interface BoardService {
    List<BoardDto> selectBoardList();

    void insertBoard(BoardDto board);

    BoardDto selectBoardDetail(int id);

    void updateBoard(BoardDto board);

    void deleteBoard(int id);
}
