package mingsuu.ColPoP.domain.auth.service;

public interface LogoutService {

    void execute(String accessToken, String refreshToken);
}
