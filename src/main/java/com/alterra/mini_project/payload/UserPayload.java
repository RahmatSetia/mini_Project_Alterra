package com.alterra.mini_project.payload;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.Date;

@Data
public class UserPayload {
    private Long id;
    private String first_name;
    private String last_name;
    private String gender;
    private String password;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;
}
