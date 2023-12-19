package mingsuu.ColPoP.domain.board.presentation;

import lombok.RequiredArgsConstructor;
import mingsuu.ColPoP.domain.board.presentation.dto.request.CreateBoardRequest;
import mingsuu.ColPoP.domain.board.service.CreateBoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final CreateBoardService createBoardService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateBoardRequest createBoardRequest) {
        createBoardService.execute(createBoardRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
