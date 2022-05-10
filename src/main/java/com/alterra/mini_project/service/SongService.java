package com.alterra.mini_project.service;

import com.alterra.mini_project.entity.Songs;
import com.alterra.mini_project.payload.SongPayload;

import java.util.List;

public interface SongService {
    List<Songs> getAll();
    Songs getById(Long id);
    Songs createSong(SongPayload songPayload);
    Songs updateSong(Long id, SongPayload songPayload);
    Songs deleteSong(Long id);
}
