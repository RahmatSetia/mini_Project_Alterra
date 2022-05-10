package com.alterra.mini_project.repository;

import com.alterra.mini_project.entity.PlaySongs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaySongRepository extends JpaRepository<PlaySongs, Long> {
}
