package com.theSilentBell.HelpForge.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {
    @PostMapping(
            value = "/upload",
            consumes = "multipart/form-data"
    )
    public String upload(@RequestParam("file") MultipartFile file) {
        try {
            System.out.println(file.getName());
            return file.getOriginalFilename();
        }  catch (Exception e) {
            return e.getMessage();
        }
    }
}
