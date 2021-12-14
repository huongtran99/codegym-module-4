package com.codegym.controller;

import com.codegym.model.Box;
import com.codegym.service.BoxService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/box")
public class BoxController {

    private BoxService boxService = new BoxService();

    @GetMapping("")
    public String index(Model model) {
        List<Box> boxes = boxService.findAll();
        model.addAttribute("boxes", boxes);
        return "/index";
    }

    @GetMapping("/{id}/update")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("box", boxService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(Box box) {
        int index = boxService.findByIndex(box.getId());
        boxService.update(index, box);
        return "redirect:/box";
    }

}
