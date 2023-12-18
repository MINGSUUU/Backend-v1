package mingsuu.ColPoP.domain.auth.presentation;

import lombok.RequiredArgsConstructor;
import mingsuu.ColPoP.domain.auth.presentation.dto.request.LoginRequest;
import mingsuu.ColPoP.domain.auth.presentation.dto.request.SignUpRequest;
import mingsuu.ColPoP.domain.auth.presentation.dto.response.LoginResponse;
import mingsuu.ColPoP.domain.auth.service.LoginService;
import mingsuu.ColPoP.domain.auth.service.SignUpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final SignUpService signUpService;

    private final LoginService loginService;

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
}
