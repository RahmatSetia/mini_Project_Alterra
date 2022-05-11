package com.alterra.mini_project.payload;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ArtistPayload {
    private Long id;
    private String name_artist;
    private String gender;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;
}
