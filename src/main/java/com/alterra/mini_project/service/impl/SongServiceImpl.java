package com.alterra.mini_project.service.impl;

import com.alterra.mini_project.entity.Songs;
import com.alterra.mini_project.payload.SongPayload;
import com.alterra.mini_project.repository.SongsRepository;
import com.alterra.mini_project.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {
    private final SongsRepository songsRepository;

    @Override
    public List<Songs> getAll() {
        return songsRepository.findAll();
    }

    @Override
    public Songs getById(Long id) {
        Songs songs = new Songs();
        songs = songsRepository.findById(id).orElse(null);
        return songs;
    }

    @Override
    public Songs createSong(SongPayload songPayload) {
        Songs songs = new Songs();
        songs.setTitle(songPayload.getTitle());
        songs.setId_genre(songPayload.getId_genre());
        songs.setId_artist(songPayload.getId_artist());
        songs.setYear(songPayload.getYear());
        songs.setDuration(songPayload.getDuration());
        songs.setCreated_at(songPayload.getCreated_at());
        songs.setUpdated_at(songPayload.getUpdated_at());
        return songsRepository.save(songs);
    }

    @Override
    public Songs updateSong(@PathVariable Long id, SongPayload songPayload) {
        Optional<Songs> songsById = songsRepository.findById(id);
        songsById.ifPresent(song -> {
            song.setTitle(songPayload.getTitle());
            song.setId_genre(songPayload.getId_genre());
            song.setId_artist(songPayload.getId_artist());
            song.setYear(songPayload.getYear());
            song.setDuration(songPayload.getDuration());
            song.setCreated_at(songPayload.getCreated_at());
            song.setUpdated_at(songPayload.getUpdated_at());
        });
        return songsRepository.getById(id);
    }

    @Override
    public Songs deleteSong(Long id) {
        Optional<Songs> songId = songsRepository.findById(id);
        songId.ifPresent(dell ->{
            songsRepository.delete(dell);
        });
        return songsRepository.getById(id);
    }
}
