package br.appLogin.appLogin.controller;

import br.appLogin.appLogin.model.Usuario;
import br.appLogin.appLogin.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AppLoginController {


    private UsuarioRepository ur;

    @GetMapping("")
    public String login() {
        return "login";
    }

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }


    @RequestMapping(value = "/cadastroEnviarBanco", method = RequestMethod.POST)
    public String usuarioCadastrado(@Valid Usuario usuario, BindingResult result) {


        if (result.hasErrors()) {
            return "redirect:/cadastro";
        }
        ur.save(usuario);
            return "redirect:/login";

        }

}
