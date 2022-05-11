package com.alterra.mini_project.service;

import com.alterra.mini_project.repository.ArtistRepository;
import com.alterra.mini_project.service.impl.ArtistServiceImpl;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ArtistServiceTest {

    private final EasyRandom easyRandom = new EasyRandom();
    private Long id;

    @InjectMocks
    ArtistServiceImpl artistService;

    @Mock
    ArtistRepository artistRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        id = easyRandom.nextLong();
    }

    @Test
    public void getAllArtist_WillThrowExc(){
        String error = "Not Found";
        when(artistRepository.findAll()).thenAnswer(x ->{
            throw new Exception(error);
        });
        Exception exc = assertThrows(Exception.class, () ->{
            artistService.getAllArtist();
        });
        assertTrue(exc.getMessage().equals(error));
    }

}
