package com.alterra.mini_project.service;

import com.alterra.mini_project.entity.PlaySongs;
import com.alterra.mini_project.payload.PlaySongPayload;
import com.alterra.mini_project.repository.PlaySongRepository;
import com.alterra.mini_project.service.impl.PlaySongServiceImpl;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PlaySongsRepositoryServiceTest {

    private final EasyRandom easyRandom = new EasyRandom();
    private Long id;

    @InjectMocks
    PlaySongServiceImpl playSongService;

    @Mock
    PlaySongRepository playSongRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        id = easyRandom.nextLong();
    }

    @Test
    public void getAllPlaySong_WillThrowException(){
        String error = "Not Found";
        when(playSongRepository.findAll()).thenAnswer(x ->{
            throw new Exception(error);
        });
        Exception exc = assertThrows(Exception.class, () ->{
            playSongService.getAll();
        });
        assertTrue(exc.getMessage().equals(error));
    }

    @Test
    public void getPlaySongById_WillReturnPlaySongs(){
        PlaySongs playSongs = easyRandom.nextObject(PlaySongs.class);
        when(playSongRepository.findById(id)).thenReturn(Optional.ofNullable(playSongs));
        PlaySongs psResult = playSongService.getByid(id);

        assertEquals(playSongs, psResult);
    }

//    @Test
//    public void createPlaySong_WillReturnNewPlaySong(){
//        PlaySongPayload psPayload = easyRandom.nextObject(PlaySongPayload.class);
//
//        PlaySongs ps = new PlaySongs();
//        ps.setId_song(psPayload.getId_song());
//        ps.setId_users(psPayload.getId_users());
//        ps.setCreated_at(psPayload.getCreated_at());
//        ps.setUpdated_at(psPayload.getUpdated_at());
//        when(playSongRepository.save(ps)).thenReturn(ps);
//
//        PlaySongs psResult = playSongService.createPlaySongs(psPayload);
//        assertEquals(ps, psResult);
//    }
    @Test
    public void updatePlaySong_WillReturnPlaySongEdit(){
        PlaySongPayload psPayload = easyRandom.nextObject(PlaySongPayload.class);

        Optional<PlaySongs> psById = playSongRepository.findById(id);
        psById.ifPresent(data ->{
            data.setId_song(psPayload.getId_song());
            data.setId_users(psPayload.getId_users());
            data.setCreated_at(psPayload.getCreated_at());
            data.setUpdated_at(psPayload.getUpdated_at());
        });

        when(psById).thenReturn(psById);
        PlaySongs psResult = playSongService.updatePlaySong(id, psPayload);

        assertNotEquals(psById, psResult);
    }
    @Test
    public void deletePlaySong_WillReturnNull(){
        Optional<PlaySongs> psId = playSongRepository.findById(id);
        psId.ifPresent(delete ->{
            playSongRepository.delete(delete);
        });

        when(psId).thenReturn(psId);
        PlaySongs psResult = playSongService.deletePlaySongs(id);

        assertNull(psResult);
    }
}
