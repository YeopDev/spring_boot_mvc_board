package io.github.yeop.board.mvc_board.service;

import io.github.yeop.board.mvc_board.dto.BoardDetailDto;
import io.github.yeop.board.mvc_board.dto.BoardListDto;
import io.github.yeop.board.mvc_board.dto.InsertBoardDto;
import io.github.yeop.board.mvc_board.dto.UpdateBoardDto;
import io.github.yeop.board.mvc_board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService {
//    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    @Override
    @Transactional(readOnly = true)
    public List<BoardListDto> selectBoardList() {
        return boardMapper.selectBoardList();
    }

    @Override
    public void insertBoard(InsertBoardDto board) {
        boardMapper.insertBoard(board);
    }

    @Override
    public BoardDetailDto selectBoardDetail(int id) {
        boardMapper.updateHitCount(id);
        return boardMapper.selectBoardDetail(id);
    }

    @Override
    public void updateBoard(UpdateBoardDto board) {
        boardMapper.updateBoard(board);
    }

    @Override
    public void deleteBoard(int id) {
        boardMapper.deleteBoard(id);
    }
}
