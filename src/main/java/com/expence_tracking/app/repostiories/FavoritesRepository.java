package com.expence_tracking.app.repostiories;

import com.expence_tracking.app.domain.Favorite;
import com.expence_tracking.app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorite, Long>
{
    List<Favorite> findAllByUser(User user);
}
