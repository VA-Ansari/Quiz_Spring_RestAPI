package com.arshad.quizapp.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping("home")
    public String home(){
        return "Hii";
    }
}
