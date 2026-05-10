package com.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helper.Message;
import com.scm.helper.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.Builder;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("Home Page Handler");
        model.addAttribute("name", "Sandeep Solanki");
        model.addAttribute("youtube", "learn code with durgesh");
        model.addAttribute("githubRepo", "https://github.com");
        return "home";
    }

    @RequestMapping("/about")
    public String aboutPage(Model model) {
        model.addAttribute("isLogin", true);
        System.out.println("About page loading");

        return "about";
    }

    @GetMapping("/services")
    public String services(Model model) {
        return "services";
    }

    // this is login page
    @GetMapping("/login")
    public String login() {
        return new String("login");
    }

    // this is registration view page
    @GetMapping("/register")
    public String register(Model model) {

        model.addAttribute("userForm", new UserForm());

        return new String("register");
    }

    // registration processing
    @PostMapping("/do-register")
    public String processRegister(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult rBindingResult,
            HttpSession session) {
        // fetch data from form
        System.out.println(userForm);
        // validate form data
        if (rBindingResult.hasErrors()) {
            return "register";
        }
        // TODO::Validate userForm
        // store data in database
        // save to database
        // userService

        // UserForm--->USer

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic(
                "https://stock.adobe.com/in/images/default-avatar-profile-icon-black-placeholder-man-and-woman-silhouette-style/1894319067");

        userService.saveUser(user);

        System.out.println("User saved");
        // message="registration succesfully";

        // add the message:
        Message message = Message.builder().content("Registration Successful").type(MessageType.blue).build();

        session.setAttribute("message", message);
        // redirect to login page
        return "redirect:/register";
    }

    @GetMapping("/contact")
    public String contact() {
        return new String("contact");
    }

}
