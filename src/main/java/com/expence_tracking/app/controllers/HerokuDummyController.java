package com.expence_tracking.app.controllers;

import com.expence_tracking.app.dto.view.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * If you use the free version of heroku, your app "hibernates",
 * witch means that the first ajax request takes 20 sec to get a response ...
 * so we just send 1 "dummy" request to this url when the React App starts to "wake it up"
 */
@RestController
public class HerokuDummyController {

    @PostMapping("/heroku/start")
    public ResponseEntity<Message> wakeUp() {
        return new ResponseEntity<>(new Message("app woke up"), HttpStatus.OK);
    }
}
