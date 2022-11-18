package com.lookify.mvc.repositories;

import com.lookify.mvc.models.Song;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends CrudRepository<Song,Long> {
    List<Song> findAllByOrderByRatingDesc();
    List<Song> findAllByArtistContaining(String artist);
    @Query(value="SELECT *  FROM songs ORDER BY rating DESC LIMIT 10",nativeQuery = true)
    List<Song> getTopTen();
    
}
