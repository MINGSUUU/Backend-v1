package mingsuu.ColPoP.domain.board.repository;

import mingsuu.ColPoP.domain.board.entity.Board;
import mingsuu.ColPoP.domain.board.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByBoard(Board board);
}
