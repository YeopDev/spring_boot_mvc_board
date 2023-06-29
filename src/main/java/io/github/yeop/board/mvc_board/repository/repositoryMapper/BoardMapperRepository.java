package io.github.yeop.board.mvc_board.repository.repositoryMapper;

import io.github.yeop.board.mvc_board.domain.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapperRepository {
    @Select("SELECT board_idx AS id, title, contents, hit_cnt, creator_id, created_datetime, updater_id, updated_datetime FROM t_board WHERE deleted_yn = 'N' ORDER BY board_idx DESC")
    List<Board> findByAll();

    @Insert("INSERT INTO t_board (title, contents, created_datetime, creator_id) VALUES (#{board.title}, #{board.contents}, NOW(), 'admin')")
    void insertBoard(@Param("board") Board board);

    @Update("UPDATE t_board SET hit_cnt = hit_cnt + 1 WHERE board_idx = #{id}")
    void updateHitCount(@Param("id") int id);

    @Select("SELECT board_idx AS id, title, contents, hit_cnt, creator_id, created_datetime, updater_id, updated_datetime FROM t_board WHERE board_idx = #{id} AND deleted_yn = 'N'")
    Board selectBoardDetail(@Param("id") int id);

    @Update("UPDATE t_board SET title = #{board.title}, contents = #{board.contents} WHERE board_idx = #{board.id}")
    void updateBoard(@Param("board") Board board);

    @Update("UPDATE t_board SET deleted_yn = 'Y', updated_datetime = Now(), updater_id = 'admin' WHERE board_idx = #{id}")
    void deleteBoard(@Param("id") int id);
}