package com.alterra.mini_project.service;

import com.alterra.mini_project.entity.Artist;
import com.alterra.mini_project.payload.ArtistPayload;
import com.alterra.mini_project.repository.ArtistRepository;
import com.alterra.mini_project.service.impl.ArtistServiceImpl;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

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

    @Test
    public void getArtistsById_WillReturnArtist(){
        Artist artist = easyRandom.nextObject(Artist.class);
        when(artistRepository.findById(id)).thenReturn(Optional.ofNullable(artist));
        Artist artistHasil = artistService.getById(id);
        assertEquals(artist, artistHasil);
    }

    @Test
    public void createArtist_WillReturnNewArtist(){
        ArtistPayload artistPayload = easyRandom.nextObject(ArtistPayload.class);
        Artist artist = new Artist();
        artist.setName_artist(artistPayload.getName_artist());
        artist.setGender(artistPayload.getGender());
        artist.setCreated_at(artistPayload.getCreated_at());
        artist.setUpdated_at(artistPayload.getUpdated_at());
        when(artistRepository.save(artist)).thenReturn(artist);

        Artist result = artistService.createArtist(artistPayload);
        assertEquals(artist, result);
    }

    @Test
    public void updateArtist_WillReturnArtistEdit(){
        ArtistPayload artistPayload = easyRandom.nextObject(ArtistPayload.class);

        Optional<Artist> artistID = artistRepository.findById(id);
        artistID.ifPresent(data ->{
            data.setName_artist(artistPayload.getName_artist());
            data.setGender(artistPayload.getGender());
            data.setCreated_at(artistPayload.getCreated_at());
            data.setUpdated_at(artistPayload.getUpdated_at());
        });

        when(artistID).thenReturn(artistID);
        Artist arResult = artistService.updateArtist(id,artistPayload);

        assertNotEquals(artistID, arResult);
    }

    @Test
    public void deleteArtist_WillReturnNull(){
        Optional<Artist> artistID = artistRepository.findById(id);
        artistID.ifPresent(dell ->{
            artistRepository.delete(dell);
        });

        when(artistID).thenReturn(artistID);
        Artist arResult = artistService.deleteArtist(id);

        assertNull(arResult);
    }

}
