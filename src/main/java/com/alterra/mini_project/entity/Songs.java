package com.alterra.mini_project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "songs")
public class Songs {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "id_genre")
    private Long id_genre;
    @Column(name = "id_artist")
    private Long id_artist;
    @Column(name = "year")
    private OffsetDateTime year;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "created_at")
    private OffsetDateTime created_at;
    @Column(name = "updated_at")
    private OffsetDateTime updated_at;

    @JsonManagedReference
    @OneToMany(mappedBy = "songs")
    private List<PlaySongs> playSongs;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_genre", nullable = false, insertable = false, updatable = false)
    private Songs songs;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_artist", nullable = false, insertable = false, updatable = false)
    private Artist artist;

}
