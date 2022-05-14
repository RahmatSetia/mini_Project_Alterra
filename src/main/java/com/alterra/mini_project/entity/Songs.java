package com.alterra.mini_project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "songs")
public class Songs implements Serializable {

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
    @OneToMany(mappedBy = "songs", cascade = CascadeType.ALL)
    private List<PlaySongs> playSongs;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "songs_genres",
            joinColumns = {
                    @JoinColumn(name = "song_id_genre", referencedColumnName = "id_genre",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "genre_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private Set<Genres> genres = new HashSet<>();

//    @JsonManagedReference
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "id_genre", nullable = false, insertable = false, updatable = false)
//    private Songs songs;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_artist", nullable = false, insertable = false, updatable = false)
    private Artist artist;

}
