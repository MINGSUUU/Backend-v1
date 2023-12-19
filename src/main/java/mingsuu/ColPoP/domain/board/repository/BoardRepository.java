package mingsuu.ColPoP.domain.board.repository;

import mingsuu.ColPoP.domain.board.entity.Board;
import mingsuu.ColPoP.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByAuthor(User user);
}
