package com.alterra.mini_project.repository;

import com.alterra.mini_project.entity.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genres, Long> {
}
