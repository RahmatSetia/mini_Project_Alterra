package com.alterra.mini_project.repository;

import com.alterra.mini_project.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
