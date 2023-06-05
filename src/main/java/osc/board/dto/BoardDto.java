package osc.board.dto;

import lombok.*;
import osc.board.domain.Board;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor //필드변수 생성자
public class BoardDto {

    private Long num;
    private String title;
    private String contents;
    private String  writeName;

    private LocalDateTime writeDate;
    private LocalDateTime modifyDate;


    public Board toEntity(){
        Board board = Board
                .builder()
                .writeName(this.writeName)
                .title(this.title)
                .contents(this.contents)
                .build();
        return board;
    }

    @Builder
    public BoardDto(
            Long num,
            String writeName,
            String title,
            String contents,
            LocalDateTime writeDate,
            LocalDateTime modifyDate) {

        this.num = num;
        this.writeName = writeName;
        this.title = title;
        this.contents = contents;
        this.writeDate = writeDate;
        this.modifyDate = modifyDate;
    }
}


