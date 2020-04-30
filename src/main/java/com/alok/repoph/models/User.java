package com.alok.repoph.models;

import com.alok.repoph.pojo.About;
import com.alok.repoph.pojo.Address;
import com.alok.repoph.pojo.NationalId;
import com.alok.repoph.pojo.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"),name = "app_user")
@ToString
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    @NotNull(message = "password is mandatory.")
    private String password;

    private Address address;

    private Boolean gender;

    private About about;

    private String mobileNumber;


    private NationalId nationalId;

    @NotNull(message = "email is mandatory.")
    private String email;


    private Double pricing;


    private Double estimatedTime;

    private Boolean isProfileCompleted = false;

    private Boolean hireStatus = false;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    @ElementCollection
    private List<Skill> skills;

    @ManyToMany
    private List<User> listOfHiredPeople = new ArrayList<>();

    private String status = "pending";

    private Boolean requestedForEnd = false;


    private LocalTime hiredStartTime;

    @OneToOne
    private  User whoHiredMe;


    public User(String firstName,String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName =lastName;
        this.email = email;
        this.password = password;
    }

    public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

}
