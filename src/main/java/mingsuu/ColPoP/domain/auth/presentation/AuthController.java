package mingsuu.ColPoP.domain.auth.presentation;

import lombok.RequiredArgsConstructor;
import mingsuu.ColPoP.domain.auth.presentation.dto.request.LoginRequest;
import mingsuu.ColPoP.domain.auth.presentation.dto.request.SignUpRequest;
import mingsuu.ColPoP.domain.auth.presentation.dto.response.LoginResponse;
import mingsuu.ColPoP.domain.auth.presentation.dto.response.NewTokenResponse;
import mingsuu.ColPoP.domain.auth.service.LoginService;
import mingsuu.ColPoP.domain.auth.service.ReIssueTokenService;
import mingsuu.ColPoP.domain.auth.service.SignUpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final SignUpService signUpService;

    private final LoginService loginService;

    private final ReIssueTokenService reIssueTokenService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@RequestBody SignUpRequest signUpRequest) {
        signUpService.execute(signUpRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = loginService.execute(loginRequest);
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }

    @PatchMapping("/reissue")
    public ResponseEntity<NewTokenResponse> reIssueToken(@RequestHeader("Refresh-token") String refreshToken) {
        NewTokenResponse newTokenResponse = reIssueTokenService.execute(refreshToken);
        return new ResponseEntity<>(newTokenResponse, HttpStatus.OK);
    }
}
