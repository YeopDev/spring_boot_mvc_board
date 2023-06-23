package io.github.yeop.board.mvc_board.mapper;

import io.github.yeop.board.mvc_board.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDto> selectBoardList() throws Exception;

    void insertBoard(BoardDto board) throws Exception;

    void updateHitCount(int boardIdx) throws Exception;

    BoardDto selectBoardDetail(int boardIdx) throws Exception;

    void updateBoard(BoardDto boardDto) throws Exception;

    void deleteBoard(int boardIdx) throws Exception;
}
