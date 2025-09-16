package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MarksController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm() {
        return "input";   // input.jsp
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public String calculateMarks(@RequestParam("science") int science,
                                 @RequestParam("maths") int maths,
                                 @RequestParam("english") int english,
                                 Model model) {

        int total = science + maths + english;
        model.addAttribute("science", science);
        model.addAttribute("maths", maths);
        model.addAttribute("english", english);
        model.addAttribute("total", total);

        return "result";   // result.jsp
    }
}
