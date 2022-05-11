package com.alterra.mini_project.service.impl;

import com.alterra.mini_project.entity.Genres;
import com.alterra.mini_project.payload.GenrePayload;
import com.alterra.mini_project.repository.GenreRepository;
import com.alterra.mini_project.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public List<Genres> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genres getGenreId(@PathVariable Long id) {
        Genres genres = new Genres();
        genres = genreRepository.findById(id).orElse(null);
        return null;
    }

    @Override
    public Genres createGenre(GenrePayload genrePayload) {
        Genres genres = new Genres();
        genres.setGenre_name(genrePayload.getGenre_name());
        genres.setDescriptions(genrePayload.getDescriptions());
        genres.setCreated_at(genrePayload.getCreated_at());
        genres.setUpdated_at(genrePayload.getUpdated_at());
        return genreRepository.save(genres);
    }

    @Override
    public Genres updateGenre(Long id, GenrePayload genrePayload) {
        Optional<Genres> genreID = genreRepository.findById(id);
        genreID.ifPresent(sett ->{
            sett.setGenre_name(genrePayload.getGenre_name());
            sett.setDescriptions(genrePayload.getDescriptions());
            sett.setCreated_at(genrePayload.getCreated_at());
            sett.setUpdated_at(genrePayload.getUpdated_at());
        });
        return genreRepository.getById(id);
    }

    @Override
    public Genres deleteGenre(Long id) {
        Optional<Genres> genresID = genreRepository.findById(id);
        genresID.ifPresent(dell ->{
            genreRepository.delete(dell);
        });
        return genreRepository.getById(id);
    }
}
