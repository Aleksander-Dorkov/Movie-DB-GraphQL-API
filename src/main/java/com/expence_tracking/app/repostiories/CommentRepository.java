package com.expence_tracking.app.repostiories;

import com.expence_tracking.app.domain.Comment;
import com.expence_tracking.app.domain.enums.FavoriteType;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>
{
    @EntityGraph("fetchUser")
    List<Comment> findAllByMovieDBIdAndFavoriteType(Long movieDBId, FavoriteType favoriteType);

}
