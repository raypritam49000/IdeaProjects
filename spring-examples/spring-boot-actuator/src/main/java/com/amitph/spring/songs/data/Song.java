package com.amitph.spring.songs.data;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Song {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String songId;

    private String title;
    private String album;
    private String genre;
    private Integer year;

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}