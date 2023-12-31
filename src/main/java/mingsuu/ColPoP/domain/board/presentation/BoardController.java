package mingsuu.ColPoP.domain.board.presentation;

import lombok.RequiredArgsConstructor;
import mingsuu.ColPoP.domain.board.presentation.dto.request.CommentRequest;
import mingsuu.ColPoP.domain.board.presentation.dto.request.CreateBoardRequest;
import mingsuu.ColPoP.domain.board.presentation.dto.response.BoardDetailResponse;
import mingsuu.ColPoP.domain.board.presentation.dto.response.BoardListResponse;
import mingsuu.ColPoP.domain.board.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final CreateBoardService createBoardService;

    private final BoardListService boardListService;

    private final BoardDetailService boardDetailService;

    private final CommentService commentService;

    private final MyBoardService myBoardService;

    @PostMapping("/auth")
    public ResponseEntity<Void> create(@RequestBody CreateBoardRequest createBoardRequest) {
        createBoardService.execute(createBoardRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<BoardListResponse> list() {
        BoardListResponse boardListResponse = boardListService.execute();
        return new ResponseEntity<>(boardListResponse, HttpStatus.OK);
    }

    @GetMapping("/auth/{boardId}")
    public ResponseEntity<BoardDetailResponse> detail(@PathVariable Long boardId) {
        BoardDetailResponse boardDetailResponse = boardDetailService.execute(boardId);
        return new ResponseEntity<>(boardDetailResponse, HttpStatus.OK);
    }

    @PostMapping("/auth/{boardId}")
    public ResponseEntity<Void> comment(@PathVariable Long boardId, @RequestBody CommentRequest commentRequest) {
        commentService.execute(boardId, commentRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/auth/mypage")
    public ResponseEntity<BoardListResponse> myBoardList() {
        BoardListResponse boardListResponse = myBoardService.execute();
        return new ResponseEntity<>(boardListResponse, HttpStatus.OK);
    }
}
