package mingsuu.ColPoP.global.security.exception;

import lombok.Getter;
import mingsuu.ColPoP.global.error.BasicException;
import mingsuu.ColPoP.global.error.ErrorCode;

@Getter
public class TokenNotVaildException extends BasicException {

    public TokenNotVaildException() {
        super(ErrorCode.TOKEN_NOT_VALID);
    }
}
