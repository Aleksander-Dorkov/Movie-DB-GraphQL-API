package com.expence_tracking.app.domain;

import com.expence_tracking.app.domain.enums.RatingType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ratings")
public class Rating
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_generator")
    @SequenceGenerator(name = "rating_generator", sequenceName = "rating_seq", allocationSize = 1)
    private Long ratingId;
    private Integer rating;
    @Enumerated(EnumType.STRING)
    private RatingType favoriteType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

}
