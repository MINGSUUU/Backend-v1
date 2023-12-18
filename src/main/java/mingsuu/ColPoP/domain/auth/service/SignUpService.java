package mingsuu.ColPoP.domain.auth.service;

import mingsuu.ColPoP.domain.auth.presentation.dto.request.SignUpRequest;

public interface SignUpService {

    void execute(SignUpRequest signUpRequest);
}
