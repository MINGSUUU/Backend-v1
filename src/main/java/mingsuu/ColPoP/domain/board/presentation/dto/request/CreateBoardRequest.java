package mingsuu.ColPoP.domain.board.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateBoardRequest {

    @NotBlank(message = "제목을 입력해주세요")
    private String title;

    @NotBlank(message = "내용을 입력해주세요")
    private String content;

    @NotNull(message = "마감일을 입력해주세요")
    private LocalDate endDate;

    @NotEmpty(message = "모집분야를 입력해주세요")
    private List<String> fieldList;
}
