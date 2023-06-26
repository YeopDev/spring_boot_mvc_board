package io.github.yeop.board.mvc_board.service;

import io.github.yeop.board.mvc_board.dto.BoardDetailDto;
import io.github.yeop.board.mvc_board.dto.BoardListDto;
import io.github.yeop.board.mvc_board.dto.InsertBoardDto;
import io.github.yeop.board.mvc_board.dto.UpdateBoardDto;

import java.util.List;

public interface BoardService {
    List<BoardListDto> selectBoardList();

    void insertBoard(InsertBoardDto board);

    BoardDetailDto selectBoardDetail(int id);

    void updateBoard(UpdateBoardDto board);

    void deleteBoard(int id);
}
