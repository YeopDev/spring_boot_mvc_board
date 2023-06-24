package io.github.yeop.board.mvc_board.service;

import io.github.yeop.board.mvc_board.domain.BoardRepository;
import io.github.yeop.board.mvc_board.dto.BoardDto;
import io.github.yeop.board.mvc_board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
//    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    @Override
    public List<BoardDto> selectBoardList() {
        return boardMapper.selectBoardList();
    }

    @Override
    public void insertBoard(BoardDto board) {
        boardMapper.insertBoard(board);
    }

    @Override
    @Transactional
    public BoardDto selectBoardDetail(int id) {
        boardMapper.updateHitCount(id);
        return boardMapper.selectBoardDetail(id);
    }

    @Override
    public void updateBoard(BoardDto board) {
        boardMapper.updateBoard(board);
    }

    @Override
    public void deleteBoard(int id) {
        boardMapper.deleteBoard(id);
    }
}
