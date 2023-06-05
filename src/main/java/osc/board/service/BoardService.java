package osc.board.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import osc.board.domain.Board;
import osc.board.dto.BoardDto;
import osc.board.repository.BoardRepository;

import java.util.List;

@RequiredArgsConstructor //생성자 주입
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    private final ModelMapper mapper;

    @Transactional(readOnly = true)
    public List<Board> findByAll() {
        return this.boardRepository.findAll();
    }

    @Transactional(readOnly = true)
    public BoardDto findById(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("해당하는 게시물이 없습니다"));
        return mapper.map(board, BoardDto.class);
    }

    @Transactional
    public Board create(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity());
    }

    @Transactional
    public Board update(Long id, BoardDto boardDto) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("해당하는 게시물이 없습니다"));
        board.update(boardDto);
        return board;
    }

    @Transactional
    public void deleteById(Long id) {
        this.boardRepository.deleteById(id);
    }

}
