package mingsuu.ColPoP.domain.auth.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import mingsuu.ColPoP.domain.auth.entity.RefreshToken;
import mingsuu.ColPoP.domain.auth.presentation.dto.response.NewTokenResponse;
import mingsuu.ColPoP.domain.auth.repository.RefreshTokenRepository;
import mingsuu.ColPoP.domain.auth.service.ReIssueTokenService;
import mingsuu.ColPoP.global.security.exception.TokenNotVaildException;
import mingsuu.ColPoP.global.security.jwt.TokenProvider;
import mingsuu.ColPoP.global.security.jwt.properties.JwtProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;


@Service
@Transactional
@RequiredArgsConstructor
public class ReIssueTokenServiceImpl implements ReIssueTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    private final TokenProvider tokenProvider;

    private final JwtProperties jwtProperties;

    @Override
    public NewTokenResponse execute(String refreshToken) {

        String refresh = tokenProvider.parseToken(refreshToken);

        validateRefreshToken(refresh);

        String email = tokenProvider.exactEmailFromRefreshToken(refresh);

        String newAccessToken = tokenProvider.generateAccessToken(email);

        String newRefreshToken = tokenProvider.generateRefreshToken(email);

        ZonedDateTime accessExp = tokenProvider.accessExpiredTime();

        ZonedDateTime refreshExp = tokenProvider.refreshExpiredTime();

        RefreshToken newToken = new RefreshToken(email, newRefreshToken, tokenProvider.getTokenTimeProperties().getRefreshTime());

        refreshTokenRepository.save(newToken);

        return NewTokenResponse.builder()
                .accessToken(newAccessToken)
                .refreshToken(newRefreshToken)
                .accessExpiredAt(accessExp)
                .refreshExpiredAt(refreshExp)
                .build();
    }

    private void validateRefreshToken(String refreshToken) {

        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(jwtProperties.getRefreshSecret())
                    .build()
                    .parseClaimsJws(refreshToken)
                    .getBody();
        } catch (Exception e) {
            throw new TokenNotVaildException();
        }

        RefreshToken token = refreshTokenRepository.findByRefreshToken(refreshToken);

        if (token == null) {
            throw new TokenNotVaildException();
        }
    }
}
