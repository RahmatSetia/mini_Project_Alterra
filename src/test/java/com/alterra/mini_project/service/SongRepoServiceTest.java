package com.alterra.mini_project.service;

import com.alterra.mini_project.entity.Songs;
import com.alterra.mini_project.payload.SongPayload;
import com.alterra.mini_project.repository.SongsRepository;
import com.alterra.mini_project.service.impl.SongServiceImpl;
import lombok.experimental.StandardException;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SongRepoServiceTest {

    private final EasyRandom easyRandom = new EasyRandom();
    private Long id;

    @InjectMocks
    SongServiceImpl songServiceImpl;

    @Mock
    SongsRepository songsRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        id = easyRandom.nextLong();
    }

    @Test
    public void getAllSongs_WillThrowExc(){
        String error = "Not found";
        when(songsRepository.findAll()).thenAnswer(x ->{
            throw new Exception(error);
        });
        Exception exc = assertThrows(Exception.class, () ->{
            songServiceImpl.getAll();
        });
        assertTrue(exc.getMessage().equals(error));
    }

    @Test
    public void getSongbyId_WillReturnSong(){
        Songs songs = easyRandom.nextObject(Songs.class);
        when(songsRepository.findById(id)).thenReturn(Optional.ofNullable(songs));
        Songs songHasil = songServiceImpl.getById(id);

        assertEquals(songs, songHasil);
    }

    @Test
    public void createSong_WillReturnNewSong(){
        SongPayload songPayload = easyRandom.nextObject(SongPayload.class);

        Songs song = new Songs();
        song.setTitle(songPayload.getTitle());
        song.setId_genre(songPayload.getId_genre());
        song.setId_artist(songPayload.getId_artist());
        song.setYear(songPayload.getYear());
        song.setDuration(songPayload.getDuration());
        song.setCreated_at(songPayload.getCreated_at());
        song.setUpdated_at(songPayload.getUpdated_at());

        when(songsRepository.save(song)).thenReturn(song);
        Songs songHasil = songServiceImpl.createSong(songPayload);

        assertEquals(song, songHasil);
    }

    @Test
    public void updateSong_WillReturnSongEdit(){
        SongPayload songPayload = easyRandom.nextObject(SongPayload.class);

        Optional<Songs> songById = songsRepository.findById(id);
        songById.ifPresent(data ->{
            data.setTitle(songPayload.getTitle());
            data.setId_genre(songPayload.getId_genre());
            data.setId_artist(songPayload.getId_artist());
            data.setYear(songPayload.getYear());
            data.setDuration(songPayload.getDuration());
            data.setCreated_at(songPayload.getCreated_at());
            data.setUpdated_at(songPayload.getUpdated_at());
        });

        when(songById).thenReturn(songById);
        Songs songsHasil = songServiceImpl.updateSong(id, songPayload);

        assertNotEquals(songById, songsHasil);
    }

    @Test
    public void deleteSong_WillReturnNull(){
        Optional<Songs> songId = songsRepository.findById(id);
        songId.ifPresent(dell ->{
            songsRepository.delete(dell);
        });

        when(songId).thenReturn(songId);
        Songs songHasil = songServiceImpl.deleteSong(id);

        assertNull(songHasil);
    }
}
