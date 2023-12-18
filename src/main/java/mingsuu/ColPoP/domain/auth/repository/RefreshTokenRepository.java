package mingsuu.ColPoP.domain.auth.repository;

import mingsuu.ColPoP.domain.auth.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {

}
