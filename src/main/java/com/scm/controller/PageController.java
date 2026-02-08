package com.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model)
    {
        System.out.println("Home Page Handler");
        model.addAttribute("name","Sandeep Solanki");
        model.addAttribute("youtube","learn code with durgesh");
        model.addAttribute("githubRepo","https://github.com");
        return "home";
    }

    @RequestMapping("/about")
    public String aboutPage(Model model)
    {
        System.out.println("About page loading");
        model.addAttribute("content", "about :: content");
        return "base";
    }

    @GetMapping("/services")
    public String services(Model model) {
        model.addAttribute("content", "services :: content");
        return "base";
    }
}


