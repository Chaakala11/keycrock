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
public class Payment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LPAI_MODEPAI")
    private String lpaiModepai;

    @Column(name = "LPAI_MONTANT")
    private Long lpaiMontant;

    private Date creationDate;

    @ManyToOne
    private User employeur;

    @ManyToOne
    private User assure;




}
