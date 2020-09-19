package com.expence_tracking.app.repostiories;

import com.expence_tracking.app.domain.Category;
import com.expence_tracking.app.domain.User;
import com.expence_tracking.app.domain.enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>
{
    Category findByCategoryId(Long categoryId);

    List<Category> findAllByOwner(User user);

    @Modifying
    @Transactional
    @Query("update categories set name=:name, type=:type where categoryId=:categoryId")
    void editCategory(@Param("name") String name,
                      @Param("type") CategoryType type,
                      @Param("categoryId") Long categoryId);
}
