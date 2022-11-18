package com.lookify.mvc.services;


import com.lookify.mvc.models.Song;
import com.lookify.mvc.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;

    public Song create(Song song){
        return songRepository.save(song);
    }
    public void delete(Long id){
        songRepository.deleteById(id);
    }

    public List<Song> allSongs(){
        return (List<Song>) songRepository.findAllByOrderByRatingDesc();
    }
    public List<Song> getTopTen(){
        return songRepository.getTopTen();
    }

    public List<Song> searchArtist(String artist){
        return songRepository.findAllByArtistContaining(artist);

    }

}
