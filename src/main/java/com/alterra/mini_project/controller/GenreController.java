package com.alterra.mini_project.controller;

import com.alterra.mini_project.controller.base.BaseResponse;
import com.alterra.mini_project.entity.Genres;
import com.alterra.mini_project.payload.GenrePayload;
import com.alterra.mini_project.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/genres")
public class GenreController {

    private final GenreService genreService;

    @GetMapping
    public BaseResponse<List<Genres>> getAll(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Get all Genres");
        baseResponse.setData(genreService.getAllGenres());
        return baseResponse;
    }

    @GetMapping("{id}")
    public BaseResponse<Genres> getGenreByID(@PathVariable Long id){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Get genre by ID");
        baseResponse.setData(genreService.getGenreId(id));
        return baseResponse;
    }

    @PostMapping
    public BaseResponse<Genres> createGenre(@RequestBody GenrePayload genrePayload){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Create genre");
        baseResponse.setData(genreService.createGenre(genrePayload));
        return baseResponse;
    }

    @PutMapping("{id}")
    public BaseResponse<Genres> updateGenre(@PathVariable Long id, @RequestBody GenrePayload genrePayload){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Update Genre by ID");
        baseResponse.setData(genreService.updateGenre(id, genrePayload));
        return baseResponse;
    }

    @DeleteMapping("{id}")
    public BaseResponse<Genres> deleteGenre(@PathVariable Long id){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Delete Genre");
        baseResponse.setData(genreService.deleteGenre(id));
        return baseResponse;
    }

}
