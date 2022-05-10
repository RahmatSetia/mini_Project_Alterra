package com.alterra.mini_project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "play_songs")
public class PlaySongs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_song")
    private Long id_song;
    @Column(name = "id_users")
    private Long id_users;
    @Column(name = "created_at")
    private OffsetDateTime created_at;
    @Column(name = "updated_at")
    private OffsetDateTime updated_at;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_users", nullable = false, insertable = false, updatable = false)
    private Users users;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_songs", nullable = false, insertable = false, updatable = false)
    private Songs songs;

}
