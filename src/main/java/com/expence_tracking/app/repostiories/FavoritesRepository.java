package com.expence_tracking.app.repostiories;

import com.expence_tracking.app.domain.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorite, Long>
{

}
