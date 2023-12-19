package mingsuu.ColPoP.domain.board.exception;

import lombok.Getter;
import mingsuu.ColPoP.global.error.BasicException;
import mingsuu.ColPoP.global.error.ErrorCode;

@Getter
public class BoardNotFoundException extends BasicException {

    public BoardNotFoundException() {
        super(ErrorCode.BOARD_NOT_FOUND);
    }
}
