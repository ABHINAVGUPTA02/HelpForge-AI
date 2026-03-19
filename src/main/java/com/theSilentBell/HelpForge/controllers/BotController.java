package com.theSilentBell.HelpForge.controllers;

import com.theSilentBell.HelpForge.models.FileMetaData;
import com.theSilentBell.HelpForge.services.BotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.theSilentBell.HelpForge.models.Bot;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bots")
public class BotController {

    @Autowired
    private BotService botService;

    // create a new bot
    @PostMapping
    public ResponseEntity<String> createBot(@RequestBody Bot bot) throws Exception {
        if(botService.createBot(bot)) {
            return ResponseEntity
                    .status(201)
                    .body("Bot created successfully");
        }

        return ResponseEntity
                .status(400)
                .body("Error creating bot");
    }

    // get all the bots associated with the user
    @GetMapping("/user/{username}")
    public ResponseEntity<String> getBots(@PathVariable() String username) {
        List<Bot> bots = botService.getBots(username);

        if(bots == null || bots.isEmpty()) {
            return ResponseEntity
                    .status(404)
                    .body("No bots found");
        }

        return ResponseEntity
                .status(200)
                .body("Bots found: " + bots);
    }

    // Get a specific bot
    @GetMapping(value="/{botname}/files")
    public ResponseEntity<String> getFiles(@PathVariable String botname) {
        List<FileMetaData> files = botService.getFiles(botname);

        if(files == null || files.isEmpty()) {
            return ResponseEntity
                    .status(404)
                    .body("No files found");
        }

        return ResponseEntity
                .status(200)
                .body("Files found: " + files);
    }

    @DeleteMapping(value="/{botname}")
    public ResponseEntity<String> deleteBot(@PathVariable String botname) {
        if(botService.deleteBot(botname)) {
            return ResponseEntity
                    .status(200)
                    .body("Bot deleted successfully");
        }

        return  ResponseEntity
                .status(404)
                .body("Error deleting bot");
    }
}
