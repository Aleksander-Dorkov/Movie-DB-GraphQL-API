package com.expence_tracking.app.repostiories;

import com.expence_tracking.app.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    @EntityGraph("authoritiesJoin")
    User findByUsername(String username);
}
