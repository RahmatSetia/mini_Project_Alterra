package com.alterra.mini_project.payload;


import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class PlaySongPayload {
    private Long id;
    private Long id_song;
    private Long id_users;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;
}
