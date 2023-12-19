package mingsuu.ColPoP.domain.board.service.impl;

import lombok.RequiredArgsConstructor;
import mingsuu.ColPoP.domain.board.entity.Board;
import mingsuu.ColPoP.domain.board.presentation.dto.request.CreateBoardRequest;
import mingsuu.ColPoP.domain.board.repository.BoardRepository;
import mingsuu.ColPoP.domain.board.service.CreateBoardService;
import mingsuu.ColPoP.domain.user.entity.User;
import mingsuu.ColPoP.global.util.UserUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateBoardServiceImpl implements CreateBoardService {

    private final UserUtil userUtil;

    private final BoardRepository boardRepository;

    @Override
    public void execute(CreateBoardRequest createBoardRequest) {

        User user = userUtil.currentUser();

        Board board = Board.builder()
                .title(createBoardRequest.getTitle())
                .content(createBoardRequest.getContent())
                .author(user)
                .endDate(createBoardRequest.getEndDate())
                .fieldList(new HashSet<>(createBoardRequest.getFieldList()))
                .build();

        boardRepository.save(board);
    }
}
