package mingsuu.ColPoP.global.security.jwt.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mingsuu.ColPoP.global.security.jwt.TokenProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtRequestFilter extends OncePerRequestFilter {

    private final TokenProvider tokenProvider;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String token = tokenProvider.resolveToken(request);

        if (token != null && !token.isBlank()) {

            /*if (redisUtil.hasKeyBlackList(token)) {
                throw new TokenExpiredException();
            }*/

            Authentication authentication = tokenProvider.authentication(token);

            SecurityContextHolder.getContext().setAuthentication(authentication);

            log.info("current Email = " + authentication.getName());
        }

        filterChain.doFilter(request, response);
    }
}
