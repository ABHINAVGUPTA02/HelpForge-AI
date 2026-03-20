package com.theSilentBell.HelpForge.controllers;

import com.theSilentBell.HelpForge.services.BotService;
import com.theSilentBell.HelpForge.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @Autowired
    private BotService botService;

    @PostMapping(
            value = "/upload/{botname}",
            consumes = "multipart/form-data"
    )
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,  @PathVariable("botname") String botname) {
        if( botService.getBot(botname) && fileService.uploadFile(file)) {
            return ResponseEntity
                    .status(200)
                    .body("File uploaded successfully");
        }

        return ResponseEntity
                .status(400)
                .body("File upload failed");
    }

    @DeleteMapping("/{filename}")
    public ResponseEntity<String> deleteFile(@RequestParam("filename") String filename) {
        if(fileService.deleteFile(filename)) {
            return ResponseEntity
                    .status(200)
                    .body("File deleted successfully");
        }

        return ResponseEntity
                .status(400)
                .body("File deleted failed");
    }
}
