package com.admin.client.web;

import com.admin.client.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
@RequiredArgsConstructor
public class SongController {
    private final SongService songService;

    @GetMapping
    public List<SongDto> getAll() {
        return songService.getAllSongs();
    }

    @PostMapping
    public SongDto addSong(@RequestBody SongDto dto) {
        return songService.addNewSong(dto);
    }
}