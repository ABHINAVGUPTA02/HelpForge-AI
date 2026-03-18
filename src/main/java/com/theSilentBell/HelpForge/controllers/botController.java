package com.theSilentBell.HelpForge.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.theSilentBell.HelpForge.models.Bot;

@RestController("/bot")
public class botController {

    // create a new bot
    @PostMapping
    public ResponseEntity<String> createBot(@RequestBody Bot bot) throws Exception {
        try {
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // get all the bots associated with the user
    @GetMapping
    public ResponseEntity<String> getBots() {
        try {
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Get a specific bot
    @GetMapping(value="/{botId}")
    public ResponseEntity<String> getBots(@PathVariable String botId) {
        try {
            return new ResponseEntity<>("OK", HttpStatus.OK);
        }  catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value="/{botId}")
    public ResponseEntity<String> deleteBot(@PathVariable String botId) {
        try {
            return new ResponseEntity<>("OK", HttpStatus.OK);
        }  catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
