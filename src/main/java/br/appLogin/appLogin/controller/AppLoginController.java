package br.appLogin.appLogin.controller;

import br.appLogin.appLogin.model.Usuario;
import br.appLogin.appLogin.repository.AppLoginRepository;
import br.appLogin.appLogin.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AppLoginController {



    @Autowired
    private UsuarioRepository ur;


    @Autowired
    private AppLoginRepository ar;

    @GetMapping("")
    public String login() {
        return "login";
    }

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }


    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public String usuarioCadastrado(@Valid Usuario usuario, BindingResult result) {
            if (result.hasErrors()) {
                return "redirect:/cadastro";
            }else{
                ur.save(usuario);


                return "redirect:/";
            }
        }

    @RequestMapping(value = "/" , method = RequestMethod.POST)
    public  String usuarioLogado(@Valid Usuario usuario, BindingResult result) {

        if(ur.findByNome(usuario.getNome()) == ar.findByNome(usuario.getNome()) && ur.findBySenha(usuario.getSenha()) == ar.findBySenha(usuario.getSenha())){
            return "redirect:/";
        }else{

            return "redirect:/cadastro";
        }


    }
}
