package com.alok.repoph.repository;

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

    @Query( "select u from User u inner join u.roles r where r.name in :role and u.isProfileCompleted = :isProfileCompleted" )
    List<User> findAllBySpecificRolesAndIsProfileCompleted(@Param("role") String role, @Param("isProfileCompleted") Boolean isProfileCompleted);

    @Query( "select u from User u inner join u.roles r where r.name in :role and u.isProfileCompleted = :isProfileCompleted order by u.pricing" )
    List<User> findAllBySpecificRolesAndIsProfileCompletedOrderByPricing(@Param("role") String role, @Param("isProfileCompleted") Boolean isProfileCompleted);

    @Query( "select u from User u inner join u.roles r where r.name in :role and u.isProfileCompleted = :isProfileCompleted order by u.estimatedTime" )
    List<User> findAllBySpecificRolesAndIsProfileCompletedOrderByeOrderByEstimatedTime(@Param("role") String role, @Param("isProfileCompleted") Boolean isProfileCompleted);

    @Query( "select u from User u inner join u.roles r where r.name in :role and u.isProfileCompleted = :isProfileCompleted and u.pricing <= :price" )
    List<User> findAllBySpecificRolesAndIsProfileCompletedBelowPricing(@Param("role") String role, @Param("isProfileCompleted") Boolean isProfileCompleted,@Param("price") Double price);

    @Query( "select u from User u inner join u.roles r where r.name in :role and u.isProfileCompleted = :isProfileCompleted and u.pricing <= :price order by u.pricing" )
    List<User> findAllBySpecificRolesAndIsProfileCompletedBelowPricingOrderByPricing(@Param("role") String role, @Param("isProfileCompleted") Boolean isProfileCompleted,@Param("price") Double price);

    @Query( "select u from User u inner join u.roles r where r.name in :role and u.isProfileCompleted = :isProfileCompleted and u.pricing <= :price order by u.estimatedTime" )
    List<User> findAllBySpecificRolesAndIsProfileCompletedBelowPricingOrderByEstimatedTime(@Param("role") String role, @Param("isProfileCompleted") Boolean isProfileCompleted,@Param("price") Double price);

    @Modifying
    @Query("update User u set u.password = :password where u.id = :id")
    void updatePassword(@Param("password") String password, @Param("id") Long id);
}
