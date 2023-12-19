package mingsuu.ColPoP.domain.board.service.impl;

import lombok.RequiredArgsConstructor;
import mingsuu.ColPoP.domain.board.entity.Board;
import mingsuu.ColPoP.domain.board.entity.Comment;
import mingsuu.ColPoP.domain.board.exception.BoardNotFoundException;
import mingsuu.ColPoP.domain.board.presentation.dto.response.BoardDetailResponse;
import mingsuu.ColPoP.domain.board.presentation.dto.response.CommentResponse;
import mingsuu.ColPoP.domain.board.repository.BoardRepository;
import mingsuu.ColPoP.domain.board.repository.CommentRepository;
import mingsuu.ColPoP.domain.board.service.BoardDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardDetailServiceImpl implements BoardDetailService {

    private final BoardRepository boardRepository;

    private final CommentRepository commentRepository;

    @Override
    public BoardDetailResponse execute(Long boardId) {

        Board board = boardRepository.findById(boardId)
                .orElseThrow(BoardNotFoundException::new);

        List<Comment> commentList = commentRepository.findByBoard(board);

        return BoardDetailResponse.builder()
                .boardId(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .author(board.getAuthor().getName())
                .startDate(board.getStartDate())
                .endDate(board.getEndDate())
                .fieldList(board.getFieldList())
                .commentResponseList(
                        commentList.stream()
                                .map(CommentResponse::toResponse)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
