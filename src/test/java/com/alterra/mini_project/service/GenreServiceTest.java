package com.alterra.mini_project.service;

import com.alterra.mini_project.entity.Genres;
import com.alterra.mini_project.payload.GenrePayload;
import com.alterra.mini_project.repository.GenreRepository;
import com.alterra.mini_project.service.impl.GenreServiceImpl;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GenreServiceTest {

    private final EasyRandom easyRandom = new EasyRandom();
    private Long id;

    @InjectMocks
    GenreServiceImpl genreService;

    @Mock
    GenreRepository genreRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        id = easyRandom.nextLong();
    }

    @Test
    public void getAllGenre_WillThrowExc(){
        String error = "Not Found";
        when(genreRepository.findAll()).thenAnswer(x -> {
            throw new Exception(error);
        });
        Exception exc = assertThrows(Exception.class, () ->{
            genreService.getAllGenres();
        });
        assertTrue(exc.getMessage().equals(error));
    }

    @Test
    public void getGenreByID_WillReturnGenre(){
        Genres genres = easyRandom.nextObject(Genres.class);
        when(genreRepository.findById(id)).thenReturn(Optional.ofNullable(genres));
        Genres genresResult = genreService.getGenreId(id);

        assertEquals(genres, genresResult);
    }

//    @Test
//    public void createGenre_WillReturnNewGenre(){
//        GenrePayload genrePayload = easyRandom.nextObject(GenrePayload.class);
//
//        Genres genres = new Genres();
//        genres.setGenre_name(genrePayload.getGenre_name());
//        genres.setDescriptions(genrePayload.getDescriptions());
//        genres.setCreated_at(genrePayload.getCreated_at());
//        genres.setUpdated_at(genrePayload.getUpdated_at());
//
//        when(genreRepository.save(genres)).thenReturn(genres);
//        Genres genResult = genreService.createGenre(genrePayload);
//
//        assertEquals(genres, genResult);
//    }

    @Test
    public void updateGenre_WillReturnGenreEdit(){
        GenrePayload genrePayload = easyRandom.nextObject(GenrePayload.class);

        Optional<Genres> genreID = genreRepository.findById(id);
        genreID.ifPresent(data ->{
            data.setGenre_name(genrePayload.getGenre_name());
            data.setDescriptions(genrePayload.getDescriptions());
            data.setCreated_at(genrePayload.getCreated_at());
            data.setUpdated_at(genrePayload.getUpdated_at());
        });

        when(genreID).thenReturn(genreID);
        Genres genResult = genreService.updateGenre(id, genrePayload);

        assertNotEquals(genreID, genResult);
    }

    @Test
    public void deleteGenre_WillReturnNull(){
        Optional<Genres> genreID = genreRepository.findById(id);
        genreID.ifPresent(dell -> {
            genreRepository.delete(dell);
        });

        when(genreID).thenReturn(genreID);
        Genres genres = genreService.deleteGenre(id);

        assertNull(genres);
    }

}
