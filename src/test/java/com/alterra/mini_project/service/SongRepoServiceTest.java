package com.alterra.mini_project.service;

import com.alterra.mini_project.repository.SongsRepository;
import com.alterra.mini_project.service.impl.SongServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SongRepoServiceTest {

    @InjectMocks
    SongServiceImpl songServiceImpl;

    @Mock
    SongsRepository songsRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
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
}
