package com.alok.repoph.repository;

import com.alok.repoph.models.UtilityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UtilityUserDao extends JpaRepository<UtilityUser,Long> {

    UtilityUser findByEmail(String email);

    Optional<UtilityUser> findById(Long id);

    List<UtilityUser> findAllByRole(String role);

    @Modifying
    @Query("update UtilityUser u set u.password = :password where u.id = :id")
    void updatePassword(@Param("password") String password, @Param("id") Long id);
}
