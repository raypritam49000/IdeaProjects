package com.admin.client.service;

import com.admin.client.data.SongRepository;
import com.admin.client.web.SongDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SongService {
    private final SongRepository repository;
    private final SongTransformer transformer;

    public List<SongDto> getAllSongs() {
        return repository.findAll().stream().map(transformer::transform).collect(Collectors.toList());
    }

    public SongDto addNewSong(SongDto dto) {
        return transformer.transform(repository.save(transformer.transform(dto)));
    }
}