package com.alterra.mini_project.repository;

import com.alterra.mini_project.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    //mengambil data berdasarkan username
    Users getDisticntTopByUsername(String username);
}
