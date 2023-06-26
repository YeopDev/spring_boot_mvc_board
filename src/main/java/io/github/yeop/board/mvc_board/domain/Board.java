package io.github.yeop.board.mvc_board.domain;

public record Board(int id, String title, String contents, int hitCnt, String creatorId, String createdDatetime,
                    String updaterId, String updatedDatetime) {
}
