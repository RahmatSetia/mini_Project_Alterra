package com.alterra.mini_project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "genres")
public class Genres {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "genre_name")
    private String genre_name;
    @Column(name = "descriptions")
    private String descriptions;
    @Column(name = "created_at")
    private OffsetDateTime created_at;
    @Column(name = "updated_at")
    private OffsetDateTime updated_at;

    @JsonBackReference
    @OneToMany(mappedBy = "songs")
    private List<Songs> songs;
}
