package com.scm.impl;

import com.scm.controller.RootController;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.scm.services.ImageService;

@Service
public class ImageServiceImp implements ImageService {

    private final RootController rootController;

    ImageServiceImp(RootController rootController) {
        this.rootController = rootController;
    }

    @Override
    public String uploadImage(MultipartFile contactImage) {
        // code likhna he jo image ko upload kr rha he

        // and return kr raha hoga :url

        return "";

    }

}
