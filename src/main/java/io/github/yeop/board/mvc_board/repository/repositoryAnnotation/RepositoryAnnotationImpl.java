package io.github.yeop.board.mvc_board.repository.repositoryAnnotation;

import io.github.yeop.board.mvc_board.domain.Board;

public class RepositoryAnnotationImpl {
    public static String findByAll() {
        return "SELECT board_idx AS id, title, contents, hit_cnt, creator_id, created_datetime, updater_id, updated_datetime FROM t_board WHERE deleted_yn = 'N' ORDER BY board_idx DESC";
    }

    public static String insertBoard(Board board) {
        return "INSERT INTO t_board (title, contents, created_datetime, creator_id) VALUES (#{title}, #{contents}, NOW(), 'admin')";
    }

    public static String updateHitCount(int id) {
        return "UPDATE t_board SET hit_cnt = hit_cnt + 1 WHERE board_idx = #{id}";
    }

    public static String selectBoardDetail(int id) {
        return "SELECT board_idx AS id, title, contents, hit_cnt, creator_id, created_datetime, updater_id, updated_datetime, FROM t_board WHERE board_idx = #{id} AND deleted_yn = 'N'";
    }

    public static String updateBoard(Board board) {
        return "UPDATE t_board SET title = #{title}, contents = #{contents} WHERE board_idx = #{id}";
    }

    public static String deleteBoard(int id) {
        return "UPDATE t_board SET deleted_yn = 'Y', updated_datetime = Now(), updater_id = 'admin' WHERE board_idx = #{id}";
    }
}