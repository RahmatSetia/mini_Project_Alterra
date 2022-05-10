package com.alterra.mini_project.controller.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BaseResponse<T> {
    private Boolean success;
    private String message;
    private T data;
}
