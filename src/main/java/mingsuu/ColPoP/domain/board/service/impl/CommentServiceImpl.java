package mingsuu.ColPoP.domain.board.service.impl;

import lombok.RequiredArgsConstructor;
import mingsuu.ColPoP.domain.board.entity.Board;
import mingsuu.ColPoP.domain.board.entity.Comment;
import mingsuu.ColPoP.domain.board.exception.BoardNotFoundException;
import mingsuu.ColPoP.domain.board.presentation.dto.request.CommentRequest;
import mingsuu.ColPoP.domain.board.repository.BoardRepository;
import mingsuu.ColPoP.domain.board.repository.CommentRepository;
import mingsuu.ColPoP.domain.board.service.CommentService;
import mingsuu.ColPoP.domain.user.entity.User;
import mingsuu.ColPoP.global.util.UserUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    private final BoardRepository boardRepository;

    private final UserUtil userUtil;

    @Override
    public void execute(Long boardId, CommentRequest commentRequest) {

        User user = userUtil.currentUser();

        Board board = boardRepository.findById(boardId)
                .orElseThrow(BoardNotFoundException::new);

        Comment comment = Comment.builder()
                .comment(commentRequest.getComment())
                .author(user.getName())
                .profileUrl(user.getProfileUrl())
                .createDate(LocalDateTime.now())
                .board(board)
                .build();

        commentRepository.save(comment);
    }
}
