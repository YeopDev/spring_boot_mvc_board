package io.github.yeop.board.mvc_board.repository.repositoryProvider;

import io.github.yeop.board.mvc_board.domain.Board;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

public interface BoardRepositoryAnnotation {
    @SelectProvider(type = RepositoryAnnotationImpl.class, method = "findByAll")
    List<Board> findByAll();

    @InsertProvider(type = RepositoryAnnotationImpl.class, method = "insertBoard")
    void insertBoard(Board board);

    @UpdateProvider(type = RepositoryAnnotationImpl.class, method = "updateHitCount")
    void updateHitCount(int id);

    @SelectProvider(type = RepositoryAnnotationImpl.class, method = "selectBoardDetail")
    Board selectBoardDetail(int id);

    @UpdateProvider(type = RepositoryAnnotationImpl.class, method = "updateBoard")
    void updateBoard(Board board);

    @UpdateProvider(type = RepositoryAnnotationImpl.class, method = "deleteBoard")
    void deleteBoard(int id);
}
