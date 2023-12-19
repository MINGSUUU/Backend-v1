package mingsuu.ColPoP.domain.board.service.impl;

import lombok.RequiredArgsConstructor;
import mingsuu.ColPoP.domain.board.entity.Board;
import mingsuu.ColPoP.domain.board.presentation.dto.response.BoardListResponse;
import mingsuu.ColPoP.domain.board.presentation.dto.response.BoardResponse;
import mingsuu.ColPoP.domain.board.repository.BoardRepository;
import mingsuu.ColPoP.domain.board.service.MyBoardService;
import mingsuu.ColPoP.domain.user.entity.User;
import mingsuu.ColPoP.global.util.UserUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MyBoardServiceImpl implements MyBoardService {

    private final BoardRepository boardRepository;

    private final UserUtil userUtil;

    @Override
    public BoardListResponse execute() {

        User user = userUtil.currentUser();

        List<Board> boardList = boardRepository.findByAuthor(user);

        return BoardListResponse.builder()
                .boardResponseList(
                        boardList.stream()
                                .map(BoardResponse::toResponse)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
