package com.scm.config;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.scm.entities.Providers;
import com.scm.entities.User;
import com.scm.helper.AppConstant;
import com.scm.repositories.UserRepo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.val;

@Component
public class OAuthAuuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserRepo userRepo;

    Logger logger = LoggerFactory.getLogger(OAuthAuuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        logger.info("OAuthAuuthenticationSuccessHandler");

        // identify the provider

        var oauth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;

        String authorizedClientRegistrationId = oauth2AuthenticationToken.getAuthorizedClientRegistrationId();
        logger.info(authorizedClientRegistrationId);

        var oauth2User = (DefaultOAuth2User) authentication.getPrincipal();

        oauth2User.getAttributes().forEach((key, value) -> {
            logger.info(key + " :" + value);

        });

        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setRoleList(List.of(AppConstant.ROLE_USER));
        user.setEmailVerified(true);
        user.setEnabled(true);
        user.setPassword("dummy");

        if (authorizedClientRegistrationId.equalsIgnoreCase("google")) {

            // google
            // google attributes
            user.setEmail(oauth2User.getAttribute("email").toString());
            user.setProfilePic(oauth2User.getAttribute("picture").toString());
            user.setName(oauth2User.getAttribute("name").toString());
            user.setProvidersUserId(oauth2User.getName());
            user.setProvider(Providers.GOOGLE);
            user.setAbout("This account is created with google");

        } else if (authorizedClientRegistrationId.equalsIgnoreCase("github")) {

            // github
            // github attributes

            String email = oauth2User.getAttribute("email") != null ? oauth2User.getAttribute("email").toString()
                    : oauth2User.getAttribute("login").toString() + "@gmail.com";

            String picture = oauth2User.getAttribute("avatar_url").toString();
            String name = oauth2User.getAttribute("login").toString();
            String providerUserId = oauth2User.getName();

            user.setEmail(email);
            user.setProfilePic(picture);
            user.setName(name);
            user.setProvidersUserId(providerUserId);
            user.setProvider(Providers.GITHUB);
            user.setAbout("This account is created with github");

        } else if (authorizedClientRegistrationId.equalsIgnoreCase("Linkedin")) {

            // linkedin

        }

        else {
            logger.info("OAuthAuthenticationsuccessHandler: unknown provider");
        }

        // facebook
        // facebook attributes

        /*
         * DefaultOAuth2User user = (DefaultOAuth2User) authentication.getPrincipal();
         * 
         * // logger.info(user.getName());
         * 
         * // user.getAttributes().forEach((key, value) -> {
         * // logger.info("{}=>{}", key, value);
         * // });
         * 
         * // logger.info(user.getAuthorities().toString());
         * 
         * // save to database
         * 
         * String email = user.getAttribute("email").toString();
         * String name = user.getAttribute("name").toString();
         * String picture = user.getAttribute("picture").toString();
         * 
         * /// create user and save to database
         * User user1 = new User();
         * 
         * user1.setEmail(email);
         * user1.setName(name);
         * user1.setProfilePic(picture);
         * user1.setPassword("password");
         * user1.setUserId(UUID.randomUUID().toString());
         * user1.setProvider(Providers.GOOGLE);
         * user1.setEnabled(true);
         * user1.setEmailVerified(true);
         * user1.setProvidersUserId(user.getName());
         * user1.setRoleList(List.of(AppConstant.ROLE_USER));
         * user1.setAbout("This account created using google account");
         * 
         * User user2 = userRepo.findByEmail(email).orElse(null);
         * if (user2 == null) {
         * userRepo.save(user1);
         * logger.info("User saved:" + email);
         * }
         */

        User user2 = userRepo.findByEmail(user.getEmail()).orElse(null);
        if (user2 == null) {
            userRepo.save(user);
            logger.info("User saved:" + user.getEmail());

        }
        new DefaultRedirectStrategy().sendRedirect(request, response, "/user/profile");

    }
}
