package com.codegym;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controller {

    @GetMapping("/index")
    public ModelAndView translate(@RequestParam String input) {
        String[] english = {"Hello", "Goodbye"};
        String[] vietnam = {"xin chao", "tam biet"};
        String result = null;
        for (int i = 0; i < english.length; i++) {
            if(input.equals(english[i])) {
                result = vietnam[i];
                break;
            }
        }
        ModelAndView modelAndView = new ModelAndView("index");
        if(result != null) {
            modelAndView.addObject("result", result);
        } else {
            modelAndView.addObject("result", "?");
        }
        return  modelAndView;
    }
}
