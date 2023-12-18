package mingsuu.ColPoP.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;
import mingsuu.ColPoP.domain.user.entity.enums.Role;
import org.springframework.security.crypto.password.PasswordEncoder;

@Builder
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    private String profileUrl;

    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    public void encodePassword(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(password);
    }
}

