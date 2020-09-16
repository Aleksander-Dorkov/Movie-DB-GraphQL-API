package com.expence_tracking.app.repostiories;

import com.expence_tracking.app.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    User findByUsername(String username);
}
