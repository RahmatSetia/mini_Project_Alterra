package com.alterra.mini_project.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Setter
@Getter

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "password")
    private String password;
    @Column(name = "created_at")
    private OffsetDateTime created_at;
    @Column(name = "updated_at")
    private OffsetDateTime updated_at;

    @JsonManagedReference
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<PlaySongs> playSongs;
}
