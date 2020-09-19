package com.expence_tracking.app.repostiories;

import com.expence_tracking.app.domain.Category;
import com.expence_tracking.app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>
{
    List<Category> findAllByOwner(User user);
}
