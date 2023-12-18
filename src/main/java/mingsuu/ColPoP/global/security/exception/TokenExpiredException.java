package mingsuu.ColPoP.global.security.exception;

import lombok.Getter;
import mingsuu.ColPoP.global.error.BasicException;
import mingsuu.ColPoP.global.error.ErrorCode;

@Getter
public class TokenExpiredException extends BasicException {

    public TokenExpiredException() {
        super(ErrorCode.TOKEN_IS_EXPIRED);
    }
}
