package com.expence_tracking.app.repostiories;

import com.expence_tracking.app.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>
{
}
