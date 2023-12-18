package mingsuu.ColPoP.domain.auth.exception;

import lombok.Getter;
import mingsuu.ColPoP.global.error.BasicException;
import mingsuu.ColPoP.global.error.ErrorCode;

@Getter
public class AlreadyExistEmail extends BasicException {

    public AlreadyExistEmail() {
        super(ErrorCode.ALREADY_EXIST_EMAIL);
    }
}
