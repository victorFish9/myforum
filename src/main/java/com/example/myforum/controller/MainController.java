package com.example.myforum.controller;

import com.example.myforum.models.User;
import com.example.myforum.models.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/home")
    public String home(Model model){

        List<User> users = userRepository.findAll();

        String name = "victor";
        model.addAttribute("name", name);
        model.addAttribute("users", users);
        return "home";
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public @ResponseBody List<User> usersListRest(){return (List<User>) userRepository.findAll();}

    @GetMapping("/home/add")
    public String addUserTemplate(){
        return "add";
    }

    @PostMapping("/home/add")
    public String addUser(@RequestParam Map<String, String> newuser, HttpServletResponse response){
        System.out.println("ADD user");
        String newName = newuser.get("name");
        String newPwd = newuser.get("password");
        int newSize = Integer.parseInt(newuser.get("size"));
        userRepository.save(new User(newName,newPwd,newSize));
        response.setStatus(201);
        return "redirect:../home";
    }
}
