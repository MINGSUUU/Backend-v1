package mingsuu.ColPoP.domain.user.exception;

import mingsuu.ColPoP.global.error.BasicException;
import mingsuu.ColPoP.global.error.ErrorCode;

public class UserNotFoundException extends BasicException {

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
