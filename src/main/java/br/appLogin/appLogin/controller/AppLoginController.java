package br.appLogin.appLogin.controller;

import br.appLogin.appLogin.model.Usuario;
import br.appLogin.appLogin.repository.AppLoginRepository;
import br.appLogin.appLogin.repository.UsuarioRepository;
import br.appLogin.appLogin.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class AppLoginController {



    @Autowired
    private UsuarioRepository ur;

    @Autowired
    private AppLoginRepository ar;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("")
    public String Login(){
        return "/login.html";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String senha) {
        boolean autenticado = usuarioService.autenticar(email, senha);
        if (autenticado) {
            return ResponseEntity.status(302).header("Location", "/perfilPrincipal").build();
        } else {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }
    }


    @GetMapping("/perfilPrincipal")
    public String perfilPrincipal(){
        return "perfilPrincipal.html";

    }


    @GetMapping("/loja")
    public String loja(){
        return "loja.html";
    }

    @GetMapping("/contatos")
    public String contatos(){
        return "contatos.html";
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
        }@RequestMapping(value = "/cadastroEnviarBanco", method = RequestMethod.POST)
    public String cadastrarUsuario(@RequestParam("nome") String nome,
                                   @RequestParam("email") String email,
                                   @RequestParam("senha") String senha,
                                   @RequestParam("confirmarSenha") String confirmarSenha) {
        if (!senha.equals(confirmarSenha)) {
            return "redirect:/cadastro?error=As senhas não coincidem";
        }


        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        ur.save(usuario);

        return "redirect:/";
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
