package io.github.yeop.board.mvc_board.dto;

import io.github.yeop.board.mvc_board.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
@Builder
public class BoardDetailDto{
    private final int id;
    private final String title;
    private final String contents;
    private final int hitCnt;
    private final LocalDateTime createdDatetime;
    private final String formattedCreatedDatetime;
    private final String creatorId;

    public static BoardDetailDto from(Board board) {
        return BoardDetailDto.builder()
                .id(board.id())
                .title(board.title())
                .contents(board.contents())
                .hitCnt(board.hitCnt())
                .createdDatetime(board.createdDatetime())
                .formattedCreatedDatetime(board.createdDatetime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .creatorId(board.creatorId())
                .build();
    }
}
