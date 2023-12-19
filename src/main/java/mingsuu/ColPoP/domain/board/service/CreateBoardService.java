package mingsuu.ColPoP.domain.board.service;

import mingsuu.ColPoP.domain.board.presentation.dto.request.CreateBoardRequest;

public interface CreateBoardService {

    void execute(CreateBoardRequest createBoardRequest);
}
