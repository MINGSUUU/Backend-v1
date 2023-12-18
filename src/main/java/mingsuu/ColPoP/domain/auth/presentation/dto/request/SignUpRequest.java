package mingsuu.ColPoP.domain.auth.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import mingsuu.ColPoP.domain.user.entity.User;
import mingsuu.ColPoP.domain.user.entity.enums.Role;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpRequest {

    @NotBlank(message = "이메일을 입력해주세요")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;

    @NotBlank(message = "이미지 url 을 입력해주세요")
    private String profileUrl;

    @NotBlank(message = "이름을 입력해주세요")
    private String name;

    private Role role;

    @Builder
    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .profileUrl(profileUrl)
                .name(name)
                .role(role)
                .build();
    }
}
