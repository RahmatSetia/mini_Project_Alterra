package com.alterra.mini_project.repository;

import com.alterra.mini_project.entity.Songs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongsRepository extends JpaRepository<Songs, Long> {
}
