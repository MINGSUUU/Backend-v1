package mingsuu.ColPoP.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    //SERVER ERROR
    UNKNOWN_ERROR("알 수 없는 오류입니다.", 500),

    //TOKEN
    TOKEN_IS_EXPIRED("토큰이 만료 되었습니다.", 401),
    TOKEN_NOT_VALID("토큰이 유효 하지 않습니다.", 401),

    //USER
    ALREADY_EXIST_EMAIL("이미 존재하는 이메일입니다.", 403),
    USER_NOT_FOUND("유저를 찾을 수 없습니다.", 403),
    MISMATCH_PASSWORD("비밀번호가 맞지 않습니다.", 403);


    private final String message;
    private final int status;
}
