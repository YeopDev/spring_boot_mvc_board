package io.github.yeop.board.mvc_board.repository.repositoryXml;

import io.github.yeop.board.mvc_board.domain.Board;

import java.util.List;

public interface BoardRepository {
    List<Board> findByAll();

    void insertBoard(Board board);

    void updateHitCount(int id);

    Board selectBoardDetail(int id);

    void updateBoard(Board board);

    void deleteBoard(int id);
}
