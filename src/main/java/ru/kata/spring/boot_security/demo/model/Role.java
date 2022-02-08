package ru.kata.spring.boot_security.demo.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter
@Entity @EqualsAndHashCode
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    private String role;
}
