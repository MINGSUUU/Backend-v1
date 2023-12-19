package mingsuu.ColPoP.domain.board.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mingsuu.ColPoP.domain.board.entity.Comment;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {

    private Long commentId;

    private String comment;

    private String author;

    private String profileUrl;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createDate;

    public static CommentResponse toResponse(Comment comment) {

        return CommentResponse.builder()
                .commentId(comment.getId())
                .comment(comment.getComment())
                .author(comment.getAuthor())
                .profileUrl(comment.getProfileUrl())
                .createDate(comment.getCreateDate())
                .build();
    }
}
