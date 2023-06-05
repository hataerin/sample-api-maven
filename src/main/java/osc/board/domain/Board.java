package osc.board.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import osc.board.dto.BoardDto;

import java.time.LocalDateTime;
@Getter
@Entity
@NoArgsConstructor
@Table(name = "board")
public class Board extends BaseTime{


    @Id //pk맵핑
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk값 알아서 생성
    @Column(name = "id", nullable = false)
    private Long num;

    @Column(nullable = false)
    String writeName;

    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    String contents;

    @Builder
    public Board(
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
        super.writeDate = writeDate;
        super.modifyDate = modifyDate;
    }

    public void update(BoardDto boardDto){
        this.title = boardDto.getTitle();
        this.contents = boardDto.getContents();
        this.writeName = boardDto.getWriteName();
    }
}
