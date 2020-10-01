package com.expence_tracking.app.domain;

import com.expence_tracking.app.domain.enums.FavoriteType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "favorites")
public class Favorite
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "favorites_generator")
    @SequenceGenerator(name = "favorites_generator", sequenceName = "favorites_seq", allocationSize = 1)
    private Long favoriteId;
    private Long movieDBId;
    @Enumerated(EnumType.STRING)
    private FavoriteType favoriteType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;


}
