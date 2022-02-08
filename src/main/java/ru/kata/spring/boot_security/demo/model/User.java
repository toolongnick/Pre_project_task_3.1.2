package ru.kata.spring.boot_security.demo.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter @Setter
@EqualsAndHashCode
@Table(name = "person")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Login")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Email_address")
    private String email;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "PersonName")
    private String name;

    @Column(name = "PersonLastName")
    private String surname;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "person_role", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
