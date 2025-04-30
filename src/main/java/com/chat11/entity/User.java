package com.chat11.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(unique=true)
    String username;
    String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @Builder.Default
    Set<Role> roles = new HashSet<>();

    public void addRole (Role role) {
        roles.add(role);
    }
}
