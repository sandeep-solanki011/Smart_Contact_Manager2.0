package com.scm.helper;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

import org.springframework.security.oauth2.core.user.OAuth2User;

public class Helper {

    public static String getEmailOfLoggedInUser(Authentication authentication) {

        // agar email is password se login kiya he to email kese nikalenege

        if (authentication instanceof OAuth2AuthenticationToken) {

            var oauthToken = (OAuth2AuthenticationToken) authentication;

            var clientId = oauthToken.getAuthorizedClientRegistrationId();

            var oauth2User = (OAuth2User) authentication.getPrincipal();
            String userName = "";
            if (clientId.equalsIgnoreCase("google")) {

                // sign in with google
                userName = oauth2User.getAttribute("email").toString();

                System.out.println("Getting email from google");

            }

            else if (clientId.equalsIgnoreCase("github")) {
                System.out.println("Getting email from github");

                userName = oauth2User.getAttribute("email") != null ? oauth2User.getAttribute("email").toString()
                        : oauth2User.getAttribute("login").toString() + "@gmail.com";

            }

            // sign in with github

            return userName;
        } else {

            System.out.println("Getting email from local databse");

            return authentication.getName();

        }

    }

}
