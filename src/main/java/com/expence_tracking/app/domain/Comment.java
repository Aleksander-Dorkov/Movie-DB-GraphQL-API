package com.expence_tracking.app.domain;

import com.expence_tracking.app.domain.enums.FavoriteType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "comments")
@NamedEntityGraphs({
        @NamedEntityGraph(name = "fetchUser", attributeNodes = {
                @NamedAttributeNode("submitter")
        })
})
public class Comment
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comments_generator")
    @SequenceGenerator(name = "comments_generator", sequenceName = "comments_seq", allocationSize = 1)
    private Long commentId;
    private Long movieDBId;
    @Enumerated(EnumType.STRING)
    private FavoriteType favoriteType;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User submitter;
}
