package com.alterra.mini_project.controller;

import com.alterra.mini_project.controller.base.BaseResponse;
import com.alterra.mini_project.entity.Artist;
import com.alterra.mini_project.payload.ArtistPayload;
import com.alterra.mini_project.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistService artistService;

    @GetMapping
    public BaseResponse<List<Artist>> getAll(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Get All Artits");
        baseResponse.setData(artistService.getAllArtist());
        return baseResponse;
    }

    @GetMapping("{id}")
    public BaseResponse<Artist> getArtistsById(@PathVariable Long id){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Get Artist by ID");
        baseResponse.setData(artistService.getById(id));
        return baseResponse;
    }

    @PostMapping
    public BaseResponse<Artist> createArtist(@RequestBody ArtistPayload artistPayload){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Create Artist");
        baseResponse.setData(artistService.createArtist(artistPayload));
        return baseResponse;
    }

    @PutMapping("{id}")
    public BaseResponse<Artist> updateArtist(@PathVariable Long id, @RequestBody ArtistPayload artistPayload){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Edit Artist");
        baseResponse.setData(artistService.updateArtist(id, artistPayload));
        return baseResponse;
    }

    @DeleteMapping("{id}")
    public BaseResponse<Artist> deleteArtist(@PathVariable Long id){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Delete Artist");
        baseResponse.setData(artistService.deleteArtist(id));
        return baseResponse;
    }
}
