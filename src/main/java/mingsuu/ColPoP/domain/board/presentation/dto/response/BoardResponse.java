package mingsuu.ColPoP.domain.board.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mingsuu.ColPoP.domain.board.entity.Board;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardResponse {

    private Long boardId;

    private String title;

    private String author;

    private String profileUrl;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private Set<String> fieldList;

    public static BoardResponse toResponse(Board board) {

        return BoardResponse.builder()
                .boardId(board.getId())
                .title(board.getTitle())
                .author(board.getAuthor().getName())
                .profileUrl(board.getAuthor().getProfileUrl())
                .endDate(board.getEndDate())
                .fieldList(board.getFieldList())
                .build();
    }
}
