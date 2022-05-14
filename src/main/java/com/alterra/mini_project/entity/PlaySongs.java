package com.alterra.mini_project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "play_songs")
public class PlaySongs implements Serializable {

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
    @ManyToOne
    @JoinColumn(name = "id_users", nullable = false, insertable = false, updatable = false)
    private Users users;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_songs", nullable = false, insertable = false, updatable = false)
    private Songs songs;

}
