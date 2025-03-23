package br.appLogin.appLogin.controller;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.stereotype.Controller;

@Controller
public class AppLoginController {


    @Id
    @GeneratedValue()
    private Long id;

    private String nome;
    private String email;
    private String senha;



}
