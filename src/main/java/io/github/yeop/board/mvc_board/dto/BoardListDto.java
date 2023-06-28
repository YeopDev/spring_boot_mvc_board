package io.github.yeop.board.mvc_board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardListDto {
    private int id;
    private String title;
    private String contents;
    private int hitCnt;
    private LocalDateTime createdDatetime;
    private String formattedCreatedDatetime;
}