package com.alterra.mini_project.controller;

import com.alterra.mini_project.controller.base.BaseResponse;
import com.alterra.mini_project.entity.Songs;
import com.alterra.mini_project.payload.SongPayload;
import com.alterra.mini_project.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.prefs.BackingStoreException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;

    @GetMapping
    public BaseResponse<List<Songs>> getAll(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Get All Songs");
        baseResponse.setData(songService.getAll());
        return baseResponse;
    }

    @GetMapping("{id}")
    public BaseResponse<Songs> getById(@PathVariable Long id){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Get song by ID");
        baseResponse.setData(songService.getById(id));
        return baseResponse;
    }

    @PostMapping
    public BaseResponse<Songs> createSong(@RequestBody SongPayload songPayload){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("create Song");
        baseResponse.setData(songService.createSong(songPayload));
        return baseResponse;
    }

    @PutMapping("{id}")
    public BaseResponse<Songs> updateSong(@PathVariable Long id, @RequestBody SongPayload songPayload){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Update song");
        baseResponse.setData(songService.updateSong(id, songPayload));
        return baseResponse;
    }

    @DeleteMapping("{id}")
    public BaseResponse<Songs> deleteSong(@PathVariable Long id){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Delete Song");
        baseResponse.setData(songService.deleteSong(id));
        return baseResponse;
    }
}
