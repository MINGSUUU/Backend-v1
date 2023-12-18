package mingsuu.ColPoP.global.security.auth;

import lombok.RequiredArgsConstructor;
import mingsuu.ColPoP.domain.user.entity.User;
import mingsuu.ColPoP.domain.user.exception.UserNotFoundException;
import mingsuu.ColPoP.domain.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);

        return new AuthDetails(user);
    }
}