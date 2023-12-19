package mingsuu.ColPoP.domain.board.service.impl;

import lombok.RequiredArgsConstructor;
import mingsuu.ColPoP.domain.board.entity.Board;
import mingsuu.ColPoP.domain.board.presentation.dto.response.BoardListResponse;
import mingsuu.ColPoP.domain.board.presentation.dto.response.BoardResponse;
import mingsuu.ColPoP.domain.board.repository.BoardRepository;
import mingsuu.ColPoP.domain.board.service.BoardListService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardListServiceImpl implements BoardListService {

    private final BoardRepository boardRepository;

    @Override
    public BoardListResponse execute() {

        List<Board> boardList = boardRepository.findAll();

        return BoardListResponse.builder()
                .boardResponseList(
                        boardList.stream()
                                .map(BoardResponse::toResponse)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
