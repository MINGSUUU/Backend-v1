package mingsuu.ColPoP.domain.auth.service.impl;

import lombok.RequiredArgsConstructor;
import mingsuu.ColPoP.domain.auth.entity.RefreshToken;
import mingsuu.ColPoP.domain.auth.repository.RefreshTokenRepository;
import mingsuu.ColPoP.domain.auth.service.LogoutService;
import mingsuu.ColPoP.global.redis.util.RedisUtil;
import mingsuu.ColPoP.global.security.exception.TokenNotVaildException;
import mingsuu.ColPoP.global.security.jwt.TokenProvider;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LogoutServiceImpl implements LogoutService {

    private final RefreshTokenRepository refreshTokenRepository;

    private final TokenProvider tokenProvider;

    private final RedisUtil redisUtil;

    @Override
    public void execute(String accessToken, String refreshToken) {

        String access = tokenProvider.parseToken(accessToken);

        String refresh = tokenProvider.parseToken(refreshToken);

        RefreshToken userRefreshToken = refreshTokenRepository.findByRefreshToken(refresh);

        if (userRefreshToken == null) {
            throw new TokenNotVaildException();
        }

        refreshTokenRepository.delete(userRefreshToken);

        Long expiration = tokenProvider.getExpiration(access);

        redisUtil.setBlackList(access, "logout", expiration);
    }
}
