package io.github.yeop.board.mvc_board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardListDto {
    private final int id;
    private final String title;
    private final String contents;
    private final int hitCnt;
    private final String createdDatetime;
}