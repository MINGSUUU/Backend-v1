package mingsuu.ColPoP.domain.auth.service.impl;

import lombok.RequiredArgsConstructor;
import mingsuu.ColPoP.domain.auth.entity.RefreshToken;
import mingsuu.ColPoP.domain.auth.presentation.dto.request.LoginRequest;
import mingsuu.ColPoP.domain.auth.presentation.dto.response.LoginResponse;
import mingsuu.ColPoP.domain.auth.repository.RefreshTokenRepository;
import mingsuu.ColPoP.domain.auth.service.LoginService;
import mingsuu.ColPoP.domain.user.entity.User;
import mingsuu.ColPoP.domain.user.exception.MismatchPasswordException;
import mingsuu.ColPoP.domain.user.exception.UserNotFoundException;
import mingsuu.ColPoP.domain.user.repository.UserRepository;
import mingsuu.ColPoP.global.security.jwt.TokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final TokenProvider tokenProvider;

    private final UserRepository userRepository;

    private final RefreshTokenRepository refreshTokenRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponse execute(LoginRequest loginRequest) {

        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(UserNotFoundException::new);

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new MismatchPasswordException();
        }

        String accessToken = tokenProvider.generateAccessToken(user.getEmail());
        String refreshToken = tokenProvider.generateRefreshToken(user.getEmail());

        RefreshToken redisToken = new RefreshToken(user.getEmail(), refreshToken, tokenProvider.getTokenTimeProperties().getRefreshTime());

        refreshTokenRepository.save(redisToken);

        return LoginResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .accessExpiredAt(tokenProvider.accessExpiredTime())
                .refreshExpiredAt(tokenProvider.refreshExpiredTime())
                .build();
    }
}
