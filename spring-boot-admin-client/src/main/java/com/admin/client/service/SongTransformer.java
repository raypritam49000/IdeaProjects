package com.admin.client.service;

import com.admin.client.data.Song;
import com.admin.client.web.SongDto;
import org.springframework.stereotype.Component;

@Component
public class SongTransformer {
    public SongDto transform(Song song) {
        SongDto dto = new SongDto();
        dto.setTitle(song.getTitle());
        dto.setAlbum(song.getAlbum());
        dto.setGenre(song.getGenre());
        dto.setYear(song.getYear());
        dto.setSongId(song.getSongId());
        return dto;
    }

    public Song transform(SongDto dto) {
        Song song = new Song();
        song.setAlbum(dto.getAlbum());
        song.setGenre(dto.getGenre());
        song.setTitle(dto.getTitle());
        song.setYear(dto.getYear());
        return song;
    }
}