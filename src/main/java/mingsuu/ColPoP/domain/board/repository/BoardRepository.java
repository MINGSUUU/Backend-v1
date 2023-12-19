package mingsuu.ColPoP.domain.board.repository;

import mingsuu.ColPoP.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
