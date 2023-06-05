package osc.board.controller;

import org.springframework.web.bind.annotation.*;
import osc.board.domain.Board;
import osc.board.dto.BoardDto;
import osc.board.service.BoardService;

import java.util.List;

@RequestMapping("/boards")
@RestController
public class BoardController {

    //생성자 의존성 주입
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    //게시판 목록 조회
    @GetMapping
    public List<Board> findAll(){
        return boardService.findByAll();
    }

    //게시판 상세 조회
    @GetMapping("/{id}")
    public BoardDto findById(@PathVariable Long id) {
        return boardService.findById(id);
    }

    //게시글 등록
    @PostMapping
    public Board create(@RequestBody  BoardDto boardDto) {
        return boardService.create(boardDto);
    }


    //게시글 수정
    @PostMapping("/{id}")
    public Board update(@PathVariable Long id, @RequestBody BoardDto boardDto) {
        return boardService.update(id, boardDto);
    }

    //게시글 삭제
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        boardService.deleteById(id);
    }
}
