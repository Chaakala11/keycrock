package com.cnss.back.Dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDto {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Date birthDate;
    private String gender;
    private String cin;
    private String rib;
    private String activity;
    private Long officeId;
    private Long employeurId;
    private Long authorityId;
}
