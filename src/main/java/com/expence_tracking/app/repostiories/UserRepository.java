package com.expence_tracking.app.repostiories;

import com.expence_tracking.app.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    @EntityGraph("authoritiesJoin")
    User findByUsername(String username);

    @EntityGraph("authoritiesJoin")
    User findByUserId(Long id);

    @EntityGraph("authoritiesJoin")
    List<User> findAllBy();

    @Modifying
    @Transactional
    @Query("update User u set u.accountNonLocked=:accountNonLocked where u.userId=:userId")
    void updateAccountLock(@Param("accountNonLocked") boolean accountNonLocked,
                           @Param("userId") Long userId);

    @Modifying
    @Transactional
    @Query(value = "update users_authorities set authority_id=:authorityId where user_id=:userId", nativeQuery = true)
    void updateAuthority(@Param("userId") Long userId, @Param("authorityId") Long authorityId);
}
