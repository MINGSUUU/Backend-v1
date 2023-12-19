package mingsuu.ColPoP.domain.board.service;

import mingsuu.ColPoP.domain.board.presentation.dto.response.BoardDetailResponse;

public interface BoardDetailService {

    BoardDetailResponse execute(Long boardId);
}
