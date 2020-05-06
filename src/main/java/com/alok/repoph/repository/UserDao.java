package com.alok.repoph.repository;

import com.alok.repoph.models.Role;
import com.alok.repoph.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserDao extends JpaRepository<User,Long> {

    User findByEmail(String email);

    Optional<User> findById(Long id);

    List<User> findAllByIsProfileCompleted(Boolean flag);

    @Query( "select u from User u inner join u.roles r where r.name in :role" )
    List<User> findAllBySpecificRoles(@Param("role") String role);

    @Modifying
    @Query("update User u set u.password = :password where u.id = :id")
    void updatePassword(@Param("password") String password, @Param("id") Long id);
}
