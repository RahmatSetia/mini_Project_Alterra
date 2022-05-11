package com.alterra.mini_project.service.impl;

import com.alterra.mini_project.entity.PlaySongs;
import com.alterra.mini_project.payload.PlaySongPayload;
import com.alterra.mini_project.repository.PlaySongRepository;
import com.alterra.mini_project.service.PlaySongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaySongServiceImpl implements PlaySongService {

    private final PlaySongRepository playSongRepo;

    @Override
    public List<PlaySongs> getAll() {
        return playSongRepo.findAll();
    }

    @Override
    public PlaySongs getByid(@PathVariable Long id) {
        PlaySongs playSongs = new PlaySongs();
        playSongs = playSongRepo.findById(id).orElse(null);
        return playSongs;
    }

    @Override
    public PlaySongs createPlaySongs(PlaySongPayload playSongPayload) {
        PlaySongs playSongs = new PlaySongs();
        playSongs.setId_song(playSongPayload.getId_song());
        playSongs.setId_users(playSongPayload.getId_users());
        playSongs.setCreated_at(playSongPayload.getCreated_at());
        playSongs.setUpdated_at(playSongPayload.getUpdated_at());
        return playSongRepo.save(playSongs);
    }

    @Override
    public PlaySongs updatePlaySong(@PathVariable Long id, PlaySongPayload playSongPayload) {
        Optional<PlaySongs> psById = playSongRepo.findById(id);
        psById.ifPresent(sent ->{
            sent.setId_song(playSongPayload.getId_song());
            sent.setId_users(playSongPayload.getId_users());
            sent.setCreated_at(playSongPayload.getCreated_at());
            sent.setUpdated_at(playSongPayload.getUpdated_at());
        });
        return playSongRepo.getById(id);
    }

    @Override
    public PlaySongs deletePlaySongs(@PathVariable Long id) {
        Optional<PlaySongs> psId = playSongRepo.findById(id);
        psId.ifPresent(delete -> {
            playSongRepo.delete(delete);
        });
        return playSongRepo.getById(id);
    }
}
