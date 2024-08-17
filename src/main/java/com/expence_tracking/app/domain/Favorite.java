package com.expence_tracking.app.domain;

import com.expence_tracking.app.domain.enums.FavoriteType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "favorites", uniqueConstraints = {@UniqueConstraint(columnNames = {"favoriteType", "movieDBId", "user_id"})})
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "favorites_generator")
    @SequenceGenerator(name = "favorites_generator", sequenceName = "favorites_seq", allocationSize = 1)
    private Long favoriteId;
    private Long movieDBId;
    @Enumerated(EnumType.STRING)
    private FavoriteType favoriteType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;


}
