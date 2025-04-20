package com.myorganisation.healhub.entity;

import com.myorganisation.healhub.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "patient")
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String disease;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Bill bill;
}
