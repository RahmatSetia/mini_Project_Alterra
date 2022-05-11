package com.alterra.mini_project.service;

import com.alterra.mini_project.entity.Artist;
import com.alterra.mini_project.payload.ArtistPayload;

import java.util.List;

public interface ArtistService {
    List<Artist> getAllArtist();
    Artist getById(Long id);
    Artist createArtist(ArtistPayload artistPayload);
    Artist updateArtist(Long id, ArtistPayload artistPayload);
    Artist deleteArtist(Long id);
}
