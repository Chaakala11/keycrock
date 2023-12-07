package com.cnss.back.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Office {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    @Column(name = "BUR_INTIT")
    private String burIntit;


    @Column(name = "BUR_ADR")
    private String burAdr;

    @Column(name = "BUR_TEL")
    private String burTel;

    @Column(name = "BUR_FAX")
    private String burFax;

    @JsonIgnore
    @OneToMany(mappedBy = "office")
    private List<User> users;


}
