package com.alterra.mini_project.controller;

import com.alterra.mini_project.controller.base.BaseResponse;
import com.alterra.mini_project.entity.PlaySongs;
import com.alterra.mini_project.payload.PlaySongPayload;
import com.alterra.mini_project.service.PlaySongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/playsongs")
public class PlaySongController {

    private final PlaySongService psService;

    @GetMapping
    public BaseResponse<List<PlaySongs>> getAll(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Get All");
        baseResponse.setData(psService.getAll());
        return baseResponse;
    }
    @GetMapping("{id}")
    public BaseResponse<PlaySongs> getById(@PathVariable Long id){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("get By Id");
        baseResponse.setData(psService.getByid(id));
        return baseResponse;
    }
    @PostMapping
    public BaseResponse<PlaySongs> createPlaySong(@RequestBody PlaySongPayload psPayload){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("create Play Song");
        baseResponse.setData(psService.createPlaySongs(psPayload));
        return baseResponse;
    }
    @PutMapping("{id}")
    public BaseResponse<PlaySongs> updatePlaySong(@PathVariable Long id, @RequestBody PlaySongPayload psPayload){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("edit Play Song");
        baseResponse.setData(psService.updatePlaySong(id, psPayload));
        return baseResponse;
    }
    @DeleteMapping("{id}")
    public BaseResponse<PlaySongs> deletePlaySong(@PathVariable Long id){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("delete Play Song");
        baseResponse.setData(psService.deletePlaySongs(id));
        return baseResponse;
    }
}
