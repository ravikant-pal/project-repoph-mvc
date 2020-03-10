package com.alok.repoph.repository;

import com.alok.repoph.models.UtilityUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UtilityUserDao extends JpaRepository<UtilityUser,Long> {

    UtilityUser findByEmail(String email);

    Optional<UtilityUser> findById(Long id);

    List<UtilityUser> findAllByRole(String role);
}
