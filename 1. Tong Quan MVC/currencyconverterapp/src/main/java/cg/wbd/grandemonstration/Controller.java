package cg.wbd.grandemonstration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {

    @PostMapping("/index")
    public ModelAndView result(@RequestParam double usd) {
        double result = usd * 23000;
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("result", result);
        return  modelAndView;
    }
}
