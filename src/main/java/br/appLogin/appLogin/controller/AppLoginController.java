package br.appLogin.appLogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AppLoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }


}
