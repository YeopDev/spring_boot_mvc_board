package io.github.yeop.board.mvc_board.mapper;

import io.github.yeop.board.mvc_board.dto.BoardDetailDto;
import io.github.yeop.board.mvc_board.dto.BoardListDto;
import io.github.yeop.board.mvc_board.dto.InsertBoardDto;
import io.github.yeop.board.mvc_board.dto.UpdateBoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardListDto> selectBoardList();

    void insertBoard(InsertBoardDto board);

    void updateHitCount(int id);

    BoardDetailDto selectBoardDetail(int id);

    void updateBoard(UpdateBoardDto board);

    void deleteBoard(int id);
}
