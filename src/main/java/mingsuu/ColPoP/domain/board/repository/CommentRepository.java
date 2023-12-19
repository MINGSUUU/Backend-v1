package mingsuu.ColPoP.domain.board.repository;

import mingsuu.ColPoP.domain.board.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
