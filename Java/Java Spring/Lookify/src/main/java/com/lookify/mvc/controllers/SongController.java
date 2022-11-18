package com.lookify.mvc.controllers;


import com.lookify.mvc.models.Song;
import com.lookify.mvc.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping("/dashboard")
    public String allSongs(Model model, @ModelAttribute(value = "song") Song song) {
        List<Song> songs = songService.allSongs();
        model.addAttribute("songs", songs);
        return "dashboard.jsp";

    }

    @GetMapping("/songs/new")
    public String newSong(Model model, @ModelAttribute("song") Song song) {
        List<Song> songs = songService.allSongs();
        model.addAttribute("songs", songs);
        return "newSong.jsp";
    }

    @PostMapping("/songs/new")
    public String addNew(@Valid @ModelAttribute(value = "song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "newSong.jsp";
        } else {
            songService.create(song);
        }
        return "redirect:/songs/new";
    }

    @GetMapping("/TopTen")
    public String topTen(Model model){
        List<Song> topSongs= songService.getTopTen();
        model.addAttribute("topsongs",topSongs);
        return "topten.jsp";

    }

    @GetMapping("/show/{artist}")
    public String  showartist(@PathVariable("artist") String artist, Model model){
        List<Song>artist1 = songService.searchArtist(artist);
        model.addAttribute("artist",artist1);
        return "artist.jsp";

    }

    @PostMapping("/show")
    public String findArtist(@RequestParam("artist")String artist, Model model){
//        List<Song> artist1 = songService.searchArtist("artist");
        model.addAttribute("artist",artist);
        return "redirect:/show/"+artist;



    }
}
