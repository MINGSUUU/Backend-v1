package mingsuu.ColPoP.domain.auth.service;

import mingsuu.ColPoP.domain.auth.presentation.dto.request.LoginRequest;
import mingsuu.ColPoP.domain.auth.presentation.dto.response.LoginResponse;

public interface LoginService {

    LoginResponse execute(LoginRequest loginRequest);
}
