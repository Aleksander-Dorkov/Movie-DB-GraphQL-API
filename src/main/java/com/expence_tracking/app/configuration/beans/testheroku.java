package com.expence_tracking.app.configuration.beans;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testheroku
{
    @GetMapping("/test/heroku")
    public String returnSOmething(){
        return "dsadasdasasdsdadsa";
    }
}
