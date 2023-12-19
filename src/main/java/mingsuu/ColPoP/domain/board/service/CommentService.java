package mingsuu.ColPoP.domain.board.service;

import mingsuu.ColPoP.domain.board.presentation.dto.request.CommentRequest;

public interface CommentService {

    void execute(Long boardId, CommentRequest commentRequest);
}
