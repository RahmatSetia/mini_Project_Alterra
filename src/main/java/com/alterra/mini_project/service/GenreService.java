package com.alterra.mini_project.service;

import com.alterra.mini_project.entity.Genres;
import com.alterra.mini_project.payload.GenrePayload;

import java.util.List;

public interface GenreService {
    List<Genres> getAllGenres();
    Genres getGenreId(Long id);
    Genres createGenre(GenrePayload genrePayload);
    Genres updateGenre(Long id, GenrePayload genrePayload);
    Genres deleteGenre(Long id);
}
