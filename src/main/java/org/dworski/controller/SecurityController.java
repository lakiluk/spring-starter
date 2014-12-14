package org.dworski.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = {"/home", "/"})
    public String home() {
        return "home";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }
}
