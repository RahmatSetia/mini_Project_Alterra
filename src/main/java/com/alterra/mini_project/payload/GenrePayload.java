package com.alterra.mini_project.payload;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class GenrePayload {
    private Long id;
    private String genre_name;
    private String descriptions;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;
}
