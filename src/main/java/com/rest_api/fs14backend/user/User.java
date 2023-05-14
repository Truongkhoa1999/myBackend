package com.rest_api.fs14backend.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity(name = "user")
@Table(name = "customer")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(unique = true)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
    @Column(nullable = false, columnDefinition = "varchar(200)")
    private String avatar;
public enum Role {
    ADMIN, USER
}


    public User(String username, String password, String firstName, Role role, String avatar){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.role = role;
        this.avatar=avatar;
    }
}
