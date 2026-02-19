package com.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.forms.UserForm;

import org.springframework.web.bind.annotation.RequestMethod;



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
        model.addAttribute("isLogin", true);
        System.out.println("About page loading");
        
        return "about";
    }

    @GetMapping("/services")
    public String services(Model model) {
        return "services";
    }

    @GetMapping("/login")
    public String login() {
        return new String("login");
    }

      @GetMapping("/register")
    public String register(Model model) {
       UserForm userForm=new UserForm();
       model.addAttribute("userForm",userForm);
        userForm.setName("sandeep");
        return new String("register");
    }

    @RequestMapping(value="/do-register", method=RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm)
    {
        //fetch data from form
        System.out.println(userForm);
        //validate form data
        //TODO::Validate userForm
        //store data in database
        //message="registration succesfully";
        //redirect to login page
        return "redirect:/login";
    }
  
    
    

      @GetMapping("/contact")
    public String contact() {
        return new String("contact");
    }
    

}


