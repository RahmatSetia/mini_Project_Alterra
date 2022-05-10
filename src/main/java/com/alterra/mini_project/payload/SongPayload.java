package com.alterra.mini_project.payload;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class SongPayload {
    private Long id;
    private String title;
    private Long id_genre;
    private Long id_artist;
    private OffsetDateTime year;
    private Integer duration;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;
}
