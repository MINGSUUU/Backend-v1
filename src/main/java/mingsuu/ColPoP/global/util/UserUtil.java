package mingsuu.ColPoP.global.util;

import lombok.RequiredArgsConstructor;
import mingsuu.ColPoP.domain.user.entity.User;
import mingsuu.ColPoP.domain.user.exception.UserNotFoundException;
import mingsuu.ColPoP.domain.user.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserUtil {

    private final UserRepository userRepository;

    public User currentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }
}
