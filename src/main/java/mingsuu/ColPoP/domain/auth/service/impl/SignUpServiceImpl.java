package mingsuu.ColPoP.domain.auth.service.impl;

import lombok.RequiredArgsConstructor;
import mingsuu.ColPoP.domain.auth.exception.AlreadyExistEmail;
import mingsuu.ColPoP.domain.auth.presentation.dto.request.SignUpRequest;
import mingsuu.ColPoP.domain.auth.service.SignUpService;
import mingsuu.ColPoP.domain.user.entity.User;
import mingsuu.ColPoP.domain.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void execute(SignUpRequest signUpRequest) {

        if (userRepository.findByEmail(signUpRequest.getEmail()).isPresent()) {
            throw new AlreadyExistEmail();
        }

        User user = signUpRequest.toEntity();
        user.encodePassword(passwordEncoder);
        userRepository.save(user);
    }
}
