package com.alterra.mini_project.service;

import com.alterra.mini_project.entity.PlaySongs;
import com.alterra.mini_project.payload.PlaySongPayload;

import java.util.List;

public interface PlaySongService {
    List<PlaySongs> getAll();
    PlaySongs getByid(Long id);
    PlaySongs createPlaySongs(PlaySongPayload playSongPayload);
    PlaySongs updatePlaySong(Long id, PlaySongPayload playSongPayload);
    PlaySongs deletePlaySongs(Long id);
}
