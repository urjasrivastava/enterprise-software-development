package com.iiitb.esdacademicerp.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


// Handles the user's login and logout
@Controller
public class SessionController {

    @GetMapping("/login")
    public String loginScreen() {
        return "/login";
    }
}
