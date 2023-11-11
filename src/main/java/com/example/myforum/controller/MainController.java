package com.example.myforum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/home")
    public String home(Model model){
        String name = "victor";
        model.addAttribute("name", name);
        return "home";
    }
}
