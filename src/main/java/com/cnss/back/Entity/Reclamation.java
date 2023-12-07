package com.cnss.back.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Reclamation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Date creationDate;
    private boolean isResolved;

    @ManyToOne
    private User user;



}
