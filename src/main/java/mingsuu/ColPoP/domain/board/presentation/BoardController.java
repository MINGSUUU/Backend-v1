package mingsuu.ColPoP.domain.board.presentation;

import lombok.RequiredArgsConstructor;
import mingsuu.ColPoP.domain.board.presentation.dto.request.CreateBoardRequest;
import mingsuu.ColPoP.domain.board.presentation.dto.response.BoardListResponse;
import mingsuu.ColPoP.domain.board.service.BoardListService;
import mingsuu.ColPoP.domain.board.service.CreateBoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final CreateBoardService createBoardService;

    private final BoardListService boardListService;

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
}
