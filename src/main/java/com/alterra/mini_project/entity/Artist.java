package com.alterra.mini_project.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name_artist")
    private String name_artist;
    @Column(name = "gender")
    private String gender;
    @Column(name = "created_at")
    private OffsetDateTime created_at;
    @Column(name = "updated_at")
    private OffsetDateTime updated_at;

    @JsonManagedReference
    @OneToMany(mappedBy = "artist")
    private List<Songs> songs;
}
