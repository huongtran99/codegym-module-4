package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {
    @GetMapping
    public String show() {
        return "index";
    }

    @RequestMapping("/calc")
    public String save(@RequestParam("value") int[] value, @RequestParam("calculation") String calc, Model model) {
        int result = 0;
        switch (calc) {
            case "Add": {
                result = value[0] + value[1];
                break;
            }
            case "Sub": {
                result = value[0] - value[1];
                break;
            }
            case "Mul": {
                result = value[0] * value[1];
                break;
            }
            case "Div": {
                result = value[0] / value[1];
                break;
            }
        }
        model.addAttribute("result", result);
        model.addAttribute("calc", calc);
        model.addAttribute("value1", value[0]);
        model.addAttribute("value2", value[1]);
        return "index";
    }
}
