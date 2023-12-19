package mingsuu.ColPoP.domain.board.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import mingsuu.ColPoP.domain.user.entity.User;
import mingsuu.ColPoP.global.entity.BaseTimeEntity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1000)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User author;

    @Column(nullable = false)
    private LocalDate endDate;

    @ElementCollection
    @CollectionTable(name = "board_fieldList", joinColumns = @JoinColumn(name = "board_id"))
    @Column(name = "field")
    @Size(max = 4)
    @NotEmpty
    @Builder.Default
    private Set<String> fieldList = new HashSet<>();

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> commentList;
}
