package io.github.yeop.board.mvc_board.service;

import io.github.yeop.board.mvc_board.domain.Board;
import io.github.yeop.board.mvc_board.dto.BoardDetailDto;
import io.github.yeop.board.mvc_board.dto.BoardListDto;
import io.github.yeop.board.mvc_board.dto.InsertBoardDto;
import io.github.yeop.board.mvc_board.dto.UpdateBoardDto;
import io.github.yeop.board.mvc_board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    @Override
    @Transactional(readOnly = true)
    public List<BoardListDto> selectBoardList() {
        List<Board> boardList = boardRepository.selectBoardList();
        return boardList.stream()
                .map(board -> BoardListDto.builder()
                        .id(board.id())
                        .title(board.title())
                        .contents(board.contents())
                        .hitCnt(board.hitCnt())
                        .createdDatetime(board.createdDatetime())
                        .formattedCreatedDatetime(board.createdDatetime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                        .build())
                .toList();
    }

    @Override
    public void insertBoard(InsertBoardDto boardDto) {
        Board board = Board.builder()
                .id(boardDto.id())
                .title(boardDto.title())
                .contents(boardDto.contents())
                .build();
        boardRepository.insertBoard(board);
    }

    @Override
    public BoardDetailDto selectBoardDetail(int id) {
        boardRepository.updateHitCount(id);
        Board board = boardRepository.selectBoardDetail(id);
        return BoardDetailDto.from(board);
    }

    @Override
    public void updateBoard(UpdateBoardDto boardDto) {
        Board board = Board.builder()
                .id(boardDto.id())
                .title(boardDto.title())
                .contents(boardDto.contents())
                .build();
        boardRepository.updateBoard(board);
    }

    @Override
    public void deleteBoard(int id) {
        boardRepository.deleteBoard(id);
    }
}
