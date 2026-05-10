package com.scm.controller;

import com.scm.Application;

import com.scm.config.OAuthAuuthenticationSuccessHandler;
import com.scm.entities.Contact;
import com.scm.entities.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.forms.ContactForm;
import com.scm.helper.Helper;
import com.scm.helper.Message;
import com.scm.helper.MessageType;
import com.scm.services.ContactService;
import com.scm.services.ImageService;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/user/contacts")
public class ContactController {

    private Logger logger = LoggerFactory.getLogger(ContactController.class);

    private final OAuthAuuthenticationSuccessHandler OAuthAuuthenticationSuccessHandler;

    @Autowired
    private ImageService imageService;

    @Autowired
    private ContactService contactService;
    @Autowired
    private UserService userService;

    private final Application application;

    ContactController(Application application, OAuthAuuthenticationSuccessHandler OAuthAuuthenticationSuccessHandler) {
        this.application = application;
        this.OAuthAuuthenticationSuccessHandler = OAuthAuuthenticationSuccessHandler;
    }

    // add contact page handler
    @RequestMapping("/add")
    public String addContactView(Model model) {
        ContactForm contactForm = new ContactForm();
        // contactForm.setName("sAndeeep solanki");

        model.addAttribute("contactForm", contactForm);
        return "user/add_contact";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveContact(@Valid @ModelAttribute ContactForm contactForm, BindingResult result,
            Authentication authentication, HttpSession session) {

        // process the form data

        // validate form
        if (result.hasErrors()) {
            session.setAttribute("message", Message.builder()
                    .content("Please correct the  following errors").type(MessageType.red).build());
            return "user/add_contact";
        }
        // TODO :add validaion logic here

        String userName = Helper.getEmailOfLoggedInUser(authentication);

        // from->contact
        User user = userService.getUserByEmail(userName);

        // process the contact picture url

        // image process

        // upload karne ka code
        String fileURL = imageService.uploadImage(contactForm.getContactImage());

        // logger.info("file information:{}",
        // contactForm.getContactImage().getOriginalFilename());
        Contact contact = new Contact();

        contact.setName(contactForm.getName());
        contact.setFavorite(contactForm.isFavorite());
        contact.setEmail(contactForm.getEmail());
        contact.setPhoneNumber(contactForm.getPhoneNumber());
        contact.setAddress(contactForm.getAddress());
        contact.setDescription(contactForm.getDescription());
        contact.setLinkedinLink(contactForm.getLinkedinLink());
        contact.setWebsiteLink(contactForm.getWebsiteLink());
        contact.setUser(user);
        contact.setPicture(fileURL);
        // contactService.save(contact);

        System.out.println(contactForm);

        // set the contact picture url

        // set message to be displayed on the view

        session.setAttribute("message", Message.builder()
                .content("you have successfully added a new contact").type(MessageType.green).build());

        return "redirect:/user/contacts/add";

    }

}
