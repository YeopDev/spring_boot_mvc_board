package io.github.yeop.board.mvc_board.repository.repositoryXml;

import io.github.yeop.board.mvc_board.domain.Board;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@MapperScan
@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository {
    private final SqlSession sqlSession;

    @Override
    public List<Board> findByAll() {
        return sqlSession.selectList("selectBoardList");
    }

    @Override
    public void insertBoard(Board board) {
        sqlSession.insert("insertBoard", board);
    }

    @Override
    public void updateHitCount(int id) {
        sqlSession.update("updateHitCount", id);
    }

    @Override
    public Board selectBoardDetail(int id) {
        return sqlSession.selectOne("selectBoardDetail", id);
    }

    @Override
    public void updateBoard(Board board) {
        sqlSession.update("updateBoard", board);
    }

    @Override
    public void deleteBoard(int id) {
        sqlSession.update("deleteBoard", id);
    }
}
