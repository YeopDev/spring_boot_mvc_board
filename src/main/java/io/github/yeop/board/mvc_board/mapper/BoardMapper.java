package io.github.yeop.board.mvc_board.mapper;

import io.github.yeop.board.mvc_board.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDto> selectBoardList();

    void insertBoard(BoardDto board);

    void updateHitCount(int id);

    BoardDto selectBoardDetail(int id);

    void updateBoard(BoardDto board);

    void deleteBoard(int id);
}
