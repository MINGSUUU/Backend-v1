package mingsuu.ColPoP.domain.user.exception;

import mingsuu.ColPoP.global.error.BasicException;
import mingsuu.ColPoP.global.error.ErrorCode;

public class MismatchPasswordException extends BasicException {

    public MismatchPasswordException() {
        super(ErrorCode.MISMATCH_PASSWORD);
    }
}
