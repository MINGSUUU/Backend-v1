package mingsuu.ColPoP.domain.auth.service;

import mingsuu.ColPoP.domain.auth.presentation.dto.response.NewTokenResponse;

public interface ReIssueTokenService {

    NewTokenResponse execute(String refreshToken);
}
