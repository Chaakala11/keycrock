package com.cnss.back.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String phoneNumber;
    private String cin;
    private String gender;
    private Date birthDate;
    private Date creationDate;
    private Boolean isEnabled;
    private Boolean isDeleted;

    private String rib;
    private String activity;

    @ManyToOne
    private Authority authority;


    @JsonIgnore
    @OneToMany(mappedBy = "employeur")
    private List<User> assures;

    @ManyToOne
    private User employeur;

    @ManyToOne
    private Office office;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Reclamation> reclamations;

    @JsonIgnore
    @OneToMany(mappedBy = "employeur")
    private List<Payment> payments_employeur;

    @JsonIgnore
    @OneToMany(mappedBy = "assure")
    private List<Payment> payments_assure;

}
