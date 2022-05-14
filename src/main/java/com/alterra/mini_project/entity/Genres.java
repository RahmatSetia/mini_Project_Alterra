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

    @JsonManagedReference
    @ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY)
    private Set<Songs> songs = new HashSet<>();

//    @JsonBackReference
//    @OneToMany(mappedBy = "songs")
//    private List<Songs> songs;
}
