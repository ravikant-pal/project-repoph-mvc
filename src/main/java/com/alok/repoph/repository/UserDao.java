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

    @Query( "select u from User u inner join u.roles r where r.name in :role and u.isProfileCompleted = :isProfileCompleted and lower(concat(u.firstName,' ',u.lastName,' ',u.about.title,' ',u.about.description)) like  lower(concat('%',:keyword,'%'))")
    List<User> findAllBySpecificRolesAndIsProfileCompletedWithSearch(@Param("role") String role, @Param("isProfileCompleted") Boolean isProfileCompleted,@Param("keyword")String keyword);

    @Query( "select u from User u inner join u.roles r where r.name in :role and u.isProfileCompleted = :isProfileCompleted and u.pricing <= :price" )
    List<User> findAllBySpecificRolesAndIsProfileCompletedBelowPricing(@Param("role") String role, @Param("isProfileCompleted") Boolean isProfileCompleted,@Param("price") Double price);

    /*@Query( "select u from User u inner join u.roles r inner join u.skills s where r.name in :role and u.isProfileCompleted = :isProfileCompleted and u.pricing <= :price and lower(concat(u.firstName,' ',u.lastName,' ',u.about.title,' ',u.about.description)) like  lower(concat('%',:keyword,'%')) or lower(s.skillName) in :  keyword")
    List<User> findAllBySpecificRolesAndIsProfileCompletedWithSearchBelowPricing(@Param("role") String role, @Param("isProfileCompleted") Boolean isProfileCompleted,@Param("price") Double price,@Param("keyword")String keyword);
    */
    @Modifying
    @Query("update User u set u.password = :password where u.id = :id")
    void updatePassword(@Param("password") String password, @Param("id") Long id);
}
