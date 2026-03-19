package com.theSilentBell.HelpForge.controllers;

import com.theSilentBell.HelpForge.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping(
            value = "/upload",
            consumes = "multipart/form-data"
    )
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
        if(fileService.uploadFile(file)) {
            return ResponseEntity
                    .status(200)
                    .body("File uploaded successfully");
        }

        return ResponseEntity
                .status(400)
                .body("File upload failed");
    }
}
