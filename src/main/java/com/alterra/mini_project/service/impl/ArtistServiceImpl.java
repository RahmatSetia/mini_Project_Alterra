package com.alterra.mini_project.service.impl;

import com.alterra.mini_project.entity.Artist;
import com.alterra.mini_project.payload.ArtistPayload;
import com.alterra.mini_project.repository.ArtistRepository;
import com.alterra.mini_project.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.awt.image.ImagingOpException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    @Override
    public List<Artist> getAllArtist() {
        return artistRepository.findAll();
    }

    @Override
    public Artist getById(Long id) {
        Artist artist = new Artist();
        artist = artistRepository.findById(id).orElse(null);
        return artist;
    }

    @Override
    public Artist createArtist(ArtistPayload artistPayload) {
        Artist artist = new Artist();
        artist.setName_artist(artistPayload.getName_artist());
        artist.setGender(artistPayload.getGender());
        artist.setCreated_at(artistPayload.getCreated_at());
        artist.setUpdated_at(artistPayload.getUpdated_at());
        return artistRepository.save(artist);
    }

    @Override
    public Artist updateArtist(@PathVariable Long id, ArtistPayload artistPayload) {
        Optional<Artist> artistId = artistRepository.findById(id);
        artistId.ifPresent(sent ->{
            sent.setName_artist(artistPayload.getName_artist());
            sent.setGender(artistPayload.getGender());
            sent.setCreated_at(artistPayload.getCreated_at());
            sent.setUpdated_at(artistPayload.getUpdated_at());
        });
        return artistRepository.getById(id);
    }

    @Override
    public Artist deleteArtist(Long id) {
        Optional<Artist> artistId = artistRepository.findById(id);
        artistId.ifPresent(dell ->{
            artistRepository.delete(dell);
        });
        return artistRepository.getById(id);
    }
}
