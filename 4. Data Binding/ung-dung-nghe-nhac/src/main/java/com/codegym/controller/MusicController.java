package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.service.music.IMusicService;
import com.codegym.service.music.MusicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    private final IMusicService musicService = new MusicService();

    @GetMapping
    public String index(Model model) {
        List<Music> music = musicService.findAll();
        model.addAttribute("music", music);
        return "/index";
    }
}
